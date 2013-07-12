package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.nio.CharBuffer;
import java.util.HashMap;

public class Html {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.977 -0400", hash_original_method = "488A9EC3609F7D856C4CDBBB151F13E2", hash_generated_method = "03497373D06A453313C747AE9BCD9BA5")
    private  Html() {
        
    }

    
        @DSModeled(DSC.SAFE)
    public static Spanned fromHtml(String source) {
        return fromHtml(source, null, null);
    }

    
        @DSModeled(DSC.SAFE)
    public static Spanned fromHtml(String source, ImageGetter imageGetter,
                                   TagHandler tagHandler) {
        Parser parser = new Parser();
        try {
            parser.setProperty(Parser.schemaProperty, HtmlParser.schema);
        } catch (org.xml.sax.SAXNotRecognizedException e) {
            throw new RuntimeException(e);
        } catch (org.xml.sax.SAXNotSupportedException e) {
            throw new RuntimeException(e);
        }
        HtmlToSpannedConverter converter =
                new HtmlToSpannedConverter(source, imageGetter, tagHandler,
                        parser);
        return converter.convert();
    }

    
        @DSModeled(DSC.SAFE)
    public static String toHtml(Spanned text) {
        StringBuilder out = new StringBuilder();
        withinHtml(out, text);
        return out.toString();
    }

    
        @DSModeled(DSC.SAFE)
    private static void withinHtml(StringBuilder out, Spanned text) {
        int len = text.length();
        int next;
        for (int i = 0; i < text.length(); i = next) {
            next = text.nextSpanTransition(i, len, ParagraphStyle.class);
            ParagraphStyle[] style = text.getSpans(i, next, ParagraphStyle.class);
            String elements = " ";
            boolean needDiv = false;
            for(int j = 0; j < style.length; j++) {
                if (style[j] instanceof AlignmentSpan) {
                    Layout.Alignment align = 
                        ((AlignmentSpan) style[j]).getAlignment();
                    needDiv = true;
                    if (align == Layout.Alignment.ALIGN_CENTER) {
                        elements = "align=\"center\" " + elements;
                    } else if (align == Layout.Alignment.ALIGN_OPPOSITE) {
                        elements = "align=\"right\" " + elements;
                    } else {
                        elements = "align=\"left\" " + elements;
                    }
                }
            }
            if (needDiv) {
                out.append("<div " + elements + ">");
            }
            withinDiv(out, text, i, next);
            if (needDiv) {
                out.append("</div>");
            }
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static void withinDiv(StringBuilder out, Spanned text,
            int start, int end) {
        int next;
        for (int i = start; i < end; i = next) {
            next = text.nextSpanTransition(i, end, QuoteSpan.class);
            QuoteSpan[] quotes = text.getSpans(i, next, QuoteSpan.class);
            for (QuoteSpan quote: quotes) {
                out.append("<blockquote>");
            }
            withinBlockquote(out, text, i, next);
            for (QuoteSpan quote: quotes) {
                out.append("</blockquote>\n");
            }
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static void withinBlockquote(StringBuilder out, Spanned text,
                                         int start, int end) {
        out.append("<p>");
        int next;
        for (int i = start; i < end; i = next) {
            next = TextUtils.indexOf(text, '\n', i, end);
            if (next < 0) {
                next = end;
            }
            int nl = 0;
            while (next < end && text.charAt(next) == '\n') {
                nl++;
                next++;
            }
            withinParagraph(out, text, i, next - nl, nl, next == end);
        }
        out.append("</p>\n");
    }

    
        @DSModeled(DSC.SAFE)
    private static void withinParagraph(StringBuilder out, Spanned text,
                                        int start, int end, int nl,
                                        boolean last) {
        int next;
        for (int i = start; i < end; i = next) {
            next = text.nextSpanTransition(i, end, CharacterStyle.class);
            CharacterStyle[] style = text.getSpans(i, next,
                                                   CharacterStyle.class);
            for (int j = 0; j < style.length; j++) {
                if (style[j] instanceof StyleSpan) {
                    int s = ((StyleSpan) style[j]).getStyle();
                    if ((s & Typeface.BOLD) != 0) {
                        out.append("<b>");
                    }
                    if ((s & Typeface.ITALIC) != 0) {
                        out.append("<i>");
                    }
                }
                if (style[j] instanceof TypefaceSpan) {
                    String s = ((TypefaceSpan) style[j]).getFamily();
                    if (s.equals("monospace")) {
                        out.append("<tt>");
                    }
                }
                if (style[j] instanceof SuperscriptSpan) {
                    out.append("<sup>");
                }
                if (style[j] instanceof SubscriptSpan) {
                    out.append("<sub>");
                }
                if (style[j] instanceof UnderlineSpan) {
                    out.append("<u>");
                }
                if (style[j] instanceof StrikethroughSpan) {
                    out.append("<strike>");
                }
                if (style[j] instanceof URLSpan) {
                    out.append("<a href=\"");
                    out.append(((URLSpan) style[j]).getURL());
                    out.append("\">");
                }
                if (style[j] instanceof ImageSpan) {
                    out.append("<img src=\"");
                    out.append(((ImageSpan) style[j]).getSource());
                    out.append("\">");
                    i = next;
                }
                if (style[j] instanceof AbsoluteSizeSpan) {
                    out.append("<font size =\"");
                    out.append(((AbsoluteSizeSpan) style[j]).getSize() / 6);
                    out.append("\">");
                }
                if (style[j] instanceof ForegroundColorSpan) {
                    out.append("<font color =\"#");
                    String color = Integer.toHexString(((ForegroundColorSpan)
                            style[j]).getForegroundColor() + 0x01000000);
                    while (color.length() < 6) {
                        color = "0" + color;
                    }
                    out.append(color);
                    out.append("\">");
                }
            }
            withinStyle(out, text, i, next);
            for (int j = style.length - 1; j >= 0; j--) {
                if (style[j] instanceof ForegroundColorSpan) {
                    out.append("</font>");
                }
                if (style[j] instanceof AbsoluteSizeSpan) {
                    out.append("</font>");
                }
                if (style[j] instanceof URLSpan) {
                    out.append("</a>");
                }
                if (style[j] instanceof StrikethroughSpan) {
                    out.append("</strike>");
                }
                if (style[j] instanceof UnderlineSpan) {
                    out.append("</u>");
                }
                if (style[j] instanceof SubscriptSpan) {
                    out.append("</sub>");
                }
                if (style[j] instanceof SuperscriptSpan) {
                    out.append("</sup>");
                }
                if (style[j] instanceof TypefaceSpan) {
                    String s = ((TypefaceSpan) style[j]).getFamily();
                    if (s.equals("monospace")) {
                        out.append("</tt>");
                    }
                }
                if (style[j] instanceof StyleSpan) {
                    int s = ((StyleSpan) style[j]).getStyle();
                    if ((s & Typeface.BOLD) != 0) {
                        out.append("</b>");
                    }
                    if ((s & Typeface.ITALIC) != 0) {
                        out.append("</i>");
                    }
                }
            }
        }
        String p = last ? "" : "</p>\n<p>";
        if (nl == 1) {
            out.append("<br>\n");
        } else if (nl == 2) {
            out.append(p);
        } else {
            for (int i = 2; i < nl; i++) {
                out.append("<br>");
            }
            out.append(p);
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static void withinStyle(StringBuilder out, Spanned text,
                                    int start, int end) {
        for (int i = start; i < end; i++) {
            char c = text.charAt(i);
            if (c == '<') {
                out.append("&lt;");
            } else if (c == '>') {
                out.append("&gt;");
            } else if (c == '&') {
                out.append("&amp;");
            } else if (c > 0x7E || c < ' ') {
                out.append("&#" + ((int) c) + ";");
            } else if (c == ' ') {
                while (i + 1 < end && text.charAt(i + 1) == ' ') {
                    out.append("&nbsp;");
                    i++;
                }
                out.append(' ');
            } else {
                out.append(c);
            }
        }
    }

    
    private static class HtmlParser {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_method = "2BD8172A597CA1F4EC32CC40B5134462", hash_generated_method = "2BD8172A597CA1F4EC32CC40B5134462")
        public HtmlParser ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_field = "6E4DDA0794A1CCE8D6F2FA6811420D43", hash_generated_field = "BAC597DD251A1106E8D35E0F6302B278")

        private static final HTMLSchema schema = new HTMLSchema();
    }


    
    public static interface ImageGetter {
        
        public Drawable getDrawable(String source);
    }
    
    public static interface TagHandler {
        
        public void handleTag(boolean opening, String tag,
                                 Editable output, XMLReader xmlReader);
    }
    
}

class HtmlToSpannedConverter implements ContentHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "5EB2E77F51594E2C1DE90F3545DAFA8A")

    private String mSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_field = "5424551D2079C84D9F9DE456A622364D", hash_generated_field = "9F664E317A344F99238051D2F1903E54")

    private XMLReader mReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_field = "4B465DB347FF24306351EC1CAD85D0E6", hash_generated_field = "F52BFE7C8AABC90420173998C2780B6F")

    private SpannableStringBuilder mSpannableStringBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_field = "D6904A1F7372BFB73B20A639D27CE5A5", hash_generated_field = "BEF214E2C597894208A5D89455A16592")

    private Html.ImageGetter mImageGetter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_field = "7349FBA43B42948D8A0510E7FC223B0E", hash_generated_field = "11FCD8A3816FE593E534934FCEA6171D")

    private Html.TagHandler mTagHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_method = "BFBE9CD4145DCE3991FF308298481129", hash_generated_method = "23D4FCF052973F1BD05CE2C9C4218B3E")
    public  HtmlToSpannedConverter(
            String source, Html.ImageGetter imageGetter, Html.TagHandler tagHandler,
            Parser parser) {
        mSource = source;
        mSpannableStringBuilder = new SpannableStringBuilder();
        mImageGetter = imageGetter;
        mTagHandler = tagHandler;
        mReader = parser;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.980 -0400", hash_original_method = "E9DCA093295E5055C16F068195A6DE9F", hash_generated_method = "B82D119F046A87BE526B21A415A77C07")
    public Spanned convert() {
        mReader.setContentHandler(this);
        try 
        {
            mReader.parse(new InputSource(new StringReader(mSource)));
        } 
        catch (IOException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1270934518 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1270934518.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1270934518;
        } 
        catch (SAXException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_86266762 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_86266762.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_86266762;
        } 
        Object[] obj = mSpannableStringBuilder.getSpans(0, mSpannableStringBuilder.length(), ParagraphStyle.class);
for(int i = 0;i < obj.length;i++)
        {
            int start = mSpannableStringBuilder.getSpanStart(obj[i]);
            int end = mSpannableStringBuilder.getSpanEnd(obj[i]);
    if(end - 2 >= 0)            
            {
    if(mSpannableStringBuilder.charAt(end - 1) == '\n' &&
                    mSpannableStringBuilder.charAt(end - 2) == '\n')                
                {
                    end--;
                } 
            } 
    if(end == start)            
            {
                mSpannableStringBuilder.removeSpan(obj[i]);
            } 
            else
            {
                mSpannableStringBuilder.setSpan(obj[i], start, end, Spannable.SPAN_PARAGRAPH);
            } 
        } 
Spanned var5DE6A418D0AEB3D551F8691794A0FC8B_240413960 =         mSpannableStringBuilder;
        var5DE6A418D0AEB3D551F8691794A0FC8B_240413960.addTaint(taint);
        return var5DE6A418D0AEB3D551F8691794A0FC8B_240413960;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.981 -0400", hash_original_method = "D9F0F9B119583626825989DD5C2C535C", hash_generated_method = "46BEFAF18F77B93C762E0C66460036B5")
    private void handleStartTag(String tag, Attributes attributes) {
        addTaint(attributes.getTaint());
        addTaint(tag.getTaint());
    if(tag.equalsIgnoreCase("br"))        
        {
        } 
        else
    if(tag.equalsIgnoreCase("p"))        
        {
            handleP(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("div"))        
        {
            handleP(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("strong"))        
        {
            start(mSpannableStringBuilder, new Bold());
        } 
        else
    if(tag.equalsIgnoreCase("b"))        
        {
            start(mSpannableStringBuilder, new Bold());
        } 
        else
    if(tag.equalsIgnoreCase("em"))        
        {
            start(mSpannableStringBuilder, new Italic());
        } 
        else
    if(tag.equalsIgnoreCase("cite"))        
        {
            start(mSpannableStringBuilder, new Italic());
        } 
        else
    if(tag.equalsIgnoreCase("dfn"))        
        {
            start(mSpannableStringBuilder, new Italic());
        } 
        else
    if(tag.equalsIgnoreCase("i"))        
        {
            start(mSpannableStringBuilder, new Italic());
        } 
        else
    if(tag.equalsIgnoreCase("big"))        
        {
            start(mSpannableStringBuilder, new Big());
        } 
        else
    if(tag.equalsIgnoreCase("small"))        
        {
            start(mSpannableStringBuilder, new Small());
        } 
        else
    if(tag.equalsIgnoreCase("font"))        
        {
            startFont(mSpannableStringBuilder, attributes);
        } 
        else
    if(tag.equalsIgnoreCase("blockquote"))        
        {
            handleP(mSpannableStringBuilder);
            start(mSpannableStringBuilder, new Blockquote());
        } 
        else
    if(tag.equalsIgnoreCase("tt"))        
        {
            start(mSpannableStringBuilder, new Monospace());
        } 
        else
    if(tag.equalsIgnoreCase("a"))        
        {
            startA(mSpannableStringBuilder, attributes);
        } 
        else
    if(tag.equalsIgnoreCase("u"))        
        {
            start(mSpannableStringBuilder, new Underline());
        } 
        else
    if(tag.equalsIgnoreCase("sup"))        
        {
            start(mSpannableStringBuilder, new Super());
        } 
        else
    if(tag.equalsIgnoreCase("sub"))        
        {
            start(mSpannableStringBuilder, new Sub());
        } 
        else
    if(tag.length() == 2 &&
                   Character.toLowerCase(tag.charAt(0)) == 'h' &&
                   tag.charAt(1) >= '1' && tag.charAt(1) <= '6')        
        {
            handleP(mSpannableStringBuilder);
            start(mSpannableStringBuilder, new Header(tag.charAt(1) - '1'));
        } 
        else
    if(tag.equalsIgnoreCase("img"))        
        {
            startImg(mSpannableStringBuilder, attributes, mImageGetter);
        } 
        else
    if(mTagHandler != null)        
        {
            mTagHandler.handleTag(true, tag, mSpannableStringBuilder, mReader);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.982 -0400", hash_original_method = "6B986DC33BF60A186B7109194B660A70", hash_generated_method = "DCCD9F9DB769FB75E89FBD5FDBF8CDB1")
    private void handleEndTag(String tag) {
        addTaint(tag.getTaint());
    if(tag.equalsIgnoreCase("br"))        
        {
            handleBr(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("p"))        
        {
            handleP(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("div"))        
        {
            handleP(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("strong"))        
        {
            end(mSpannableStringBuilder, Bold.class, new StyleSpan(Typeface.BOLD));
        } 
        else
    if(tag.equalsIgnoreCase("b"))        
        {
            end(mSpannableStringBuilder, Bold.class, new StyleSpan(Typeface.BOLD));
        } 
        else
    if(tag.equalsIgnoreCase("em"))        
        {
            end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
        } 
        else
    if(tag.equalsIgnoreCase("cite"))        
        {
            end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
        } 
        else
    if(tag.equalsIgnoreCase("dfn"))        
        {
            end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
        } 
        else
    if(tag.equalsIgnoreCase("i"))        
        {
            end(mSpannableStringBuilder, Italic.class, new StyleSpan(Typeface.ITALIC));
        } 
        else
    if(tag.equalsIgnoreCase("big"))        
        {
            end(mSpannableStringBuilder, Big.class, new RelativeSizeSpan(1.25f));
        } 
        else
    if(tag.equalsIgnoreCase("small"))        
        {
            end(mSpannableStringBuilder, Small.class, new RelativeSizeSpan(0.8f));
        } 
        else
    if(tag.equalsIgnoreCase("font"))        
        {
            endFont(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("blockquote"))        
        {
            handleP(mSpannableStringBuilder);
            end(mSpannableStringBuilder, Blockquote.class, new QuoteSpan());
        } 
        else
    if(tag.equalsIgnoreCase("tt"))        
        {
            end(mSpannableStringBuilder, Monospace.class,
                    new TypefaceSpan("monospace"));
        } 
        else
    if(tag.equalsIgnoreCase("a"))        
        {
            endA(mSpannableStringBuilder);
        } 
        else
    if(tag.equalsIgnoreCase("u"))        
        {
            end(mSpannableStringBuilder, Underline.class, new UnderlineSpan());
        } 
        else
    if(tag.equalsIgnoreCase("sup"))        
        {
            end(mSpannableStringBuilder, Super.class, new SuperscriptSpan());
        } 
        else
    if(tag.equalsIgnoreCase("sub"))        
        {
            end(mSpannableStringBuilder, Sub.class, new SubscriptSpan());
        } 
        else
    if(tag.length() == 2 &&
                Character.toLowerCase(tag.charAt(0)) == 'h' &&
                tag.charAt(1) >= '1' && tag.charAt(1) <= '6')        
        {
            handleP(mSpannableStringBuilder);
            endHeader(mSpannableStringBuilder);
        } 
        else
    if(mTagHandler != null)        
        {
            mTagHandler.handleTag(false, tag, mSpannableStringBuilder, mReader);
        } 
        
        
    }

    
        private static void handleP(SpannableStringBuilder text) {
        int len = text.length();
        if (len >= 1 && text.charAt(len - 1) == '\n') {
            if (len >= 2 && text.charAt(len - 2) == '\n') {
                return;
            }
            text.append("\n");
            return;
        }
        if (len != 0) {
            text.append("\n\n");
        }
    }

    
        private static void handleBr(SpannableStringBuilder text) {
        text.append("\n");
    }

    
        private static Object getLast(Spanned text, Class kind) {
        Object[] objs = text.getSpans(0, text.length(), kind);
        if (objs.length == 0) {
            return null;
        } else {
            return objs[objs.length - 1];
        }
    }

    
        private static void start(SpannableStringBuilder text, Object mark) {
        int len = text.length();
        text.setSpan(mark, len, len, Spannable.SPAN_MARK_MARK);
    }

    
        private static void end(SpannableStringBuilder text, Class kind,
                            Object repl) {
        int len = text.length();
        Object obj = getLast(text, kind);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        if (where != len) {
            text.setSpan(repl, where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return;
    }

    
        private static void startImg(SpannableStringBuilder text,
                                 Attributes attributes, Html.ImageGetter img) {
        String src = attributes.getValue("", "src");
        Drawable d = null;
        if (img != null) {
            d = img.getDrawable(src);
        }
        if (d == null) {
            d = Resources.getSystem().
                    getDrawable(com.android.internal.R.drawable.unknown_image);
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        }
        int len = text.length();
        text.append("\uFFFC");
        text.setSpan(new ImageSpan(d, src), len, text.length(),
                     Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    
        private static void startFont(SpannableStringBuilder text,
                                  Attributes attributes) {
        String color = attributes.getValue("", "color");
        String face = attributes.getValue("", "face");
        int len = text.length();
        text.setSpan(new Font(color, face), len, len, Spannable.SPAN_MARK_MARK);
    }

    
        private static void endFont(SpannableStringBuilder text) {
        int len = text.length();
        Object obj = getLast(text, Font.class);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        if (where != len) {
            Font f = (Font) obj;
            if (!TextUtils.isEmpty(f.mColor)) {
                if (f.mColor.startsWith("@")) {
                    Resources res = Resources.getSystem();
                    String name = f.mColor.substring(1);
                    int colorRes = res.getIdentifier(name, "color", "android");
                    if (colorRes != 0) {
                        ColorStateList colors = res.getColorStateList(colorRes);
                        text.setSpan(new TextAppearanceSpan(null, 0, 0, colors, null),
                                where, len,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                } else {
                    int c = getHtmlColor(f.mColor);
                    if (c != -1) {
                        text.setSpan(new ForegroundColorSpan(c | 0xFF000000),
                                where, len,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }
            if (f.mFace != null) {
                text.setSpan(new TypefaceSpan(f.mFace), where, len,
                             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    
        private static void startA(SpannableStringBuilder text, Attributes attributes) {
        String href = attributes.getValue("", "href");
        int len = text.length();
        text.setSpan(new Href(href), len, len, Spannable.SPAN_MARK_MARK);
    }

    
        private static void endA(SpannableStringBuilder text) {
        int len = text.length();
        Object obj = getLast(text, Href.class);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        if (where != len) {
            Href h = (Href) obj;
            if (h.mHref != null) {
                text.setSpan(new URLSpan(h.mHref), where, len,
                             Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    
        private static void endHeader(SpannableStringBuilder text) {
        int len = text.length();
        Object obj = getLast(text, Header.class);
        int where = text.getSpanStart(obj);
        text.removeSpan(obj);
        while (len > where && text.charAt(len - 1) == '\n') {
            len--;
        }
        if (where != len) {
            Header h = (Header) obj;
            text.setSpan(new RelativeSizeSpan(HEADER_SIZES[h.mLevel]),
                         where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            text.setSpan(new StyleSpan(Typeface.BOLD),
                         where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.983 -0400", hash_original_method = "764EC710ED4FDFB68C9E6FE9ED249649", hash_generated_method = "8982242C86C53DDD9F8374B3C93C1CFB")
    public void setDocumentLocator(Locator locator) {
        addTaint(locator.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.983 -0400", hash_original_method = "FAA725B72A2ADC391C781CAB49B849AD", hash_generated_method = "F5ABC17320CB17FAFC02F6F62510312E")
    public void startDocument() throws SAXException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.983 -0400", hash_original_method = "08AD4CBC251CA96B103DE58FB6AA2921", hash_generated_method = "3ACBE0E14DE791A4A89F8374A54B4D72")
    public void endDocument() throws SAXException {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "9A8DBFCDD6673580DBBCEDB8AE69733A", hash_generated_method = "20857BED78DD6479B3F78F4A256F1BE5")
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "0E90E85A66154559EA3C98CC7177C34F", hash_generated_method = "5B3A24B5853AE441BDBBB759C4F775AE")
    public void endPrefixMapping(String prefix) throws SAXException {
        addTaint(prefix.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "5AB19A89F0F12F22375CE28650E01E88", hash_generated_method = "EB440CCEC741ABD6D7A347D2F451C4B7")
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        addTaint(attributes.getTaint());
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        handleStartTag(localName, attributes);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "56FD9F5B493653CBD1D9C50AD3B3D114", hash_generated_method = "2E29CFB35996A9818C2CB9605C18AF00")
    public void endElement(String uri, String localName, String qName) throws SAXException {
        addTaint(qName.getTaint());
        addTaint(localName.getTaint());
        addTaint(uri.getTaint());
        handleEndTag(localName);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "CA8066E430EFB34465AFA28815B509C0", hash_generated_method = "AA87CC8138ABA28B2B330DC300DBC233")
    public void characters(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
        StringBuilder sb = new StringBuilder();
for(int i = 0;i < length;i++)
        {
            char c = ch[i + start];
    if(c == ' ' || c == '\n')            
            {
                char pred;
                int len = sb.length();
    if(len == 0)                
                {
                    len = mSpannableStringBuilder.length();
    if(len == 0)                    
                    {
                        pred = '\n';
                    } 
                    else
                    {
                        pred = mSpannableStringBuilder.charAt(len - 1);
                    } 
                } 
                else
                {
                    pred = sb.charAt(len - 1);
                } 
    if(pred != ' ' && pred != '\n')                
                {
                    sb.append(' ');
                } 
            } 
            else
            {
                sb.append(c);
            } 
        } 
        mSpannableStringBuilder.append(sb);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "9049C36C2683070F72629A8BA1D4C193", hash_generated_method = "E804F1D7B5EF34836B1823F580D6DE63")
    public void ignorableWhitespace(char ch[], int start, int length) throws SAXException {
        addTaint(length);
        addTaint(start);
        addTaint(ch[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.984 -0400", hash_original_method = "D7C64873BD0FC0A0449628F53B089507", hash_generated_method = "BEB1DCA8CBE8BFAF869A1EA04F4CBAE4")
    public void processingInstruction(String target, String data) throws SAXException {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "78177C3306D49108B776A6C694C380AB")
    public void skippedEntity(String name) throws SAXException {
        addTaint(name.getTaint());
        
    }

    
        private static HashMap<String,Integer> buildColorMap() {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("aqua", 0x00FFFF);
        map.put("black", 0x000000);
        map.put("blue", 0x0000FF);
        map.put("fuchsia", 0xFF00FF);
        map.put("green", 0x008000);
        map.put("grey", 0x808080);
        map.put("lime", 0x00FF00);
        map.put("maroon", 0x800000);
        map.put("navy", 0x000080);
        map.put("olive", 0x808000);
        map.put("purple", 0x800080);
        map.put("red", 0xFF0000);
        map.put("silver", 0xC0C0C0);
        map.put("teal", 0x008080);
        map.put("white", 0xFFFFFF);
        map.put("yellow", 0xFFFF00);
        return map;
    }

    
        private static int getHtmlColor(String color) {
        Integer i = COLORS.get(color.toLowerCase());
        if (i != null) {
            return i;
        } else {
            try {
                return XmlUtils.convertValueToInt(color, -1);
            } catch (NumberFormatException nfe) {
                return -1;
            }
        }
    }

    
    private static class Bold {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "360EF21B8D8783EFA444B4BE5FDC6AD7", hash_generated_method = "360EF21B8D8783EFA444B4BE5FDC6AD7")
        public Bold ()
        {
            
        }


    }


    
    private static class Italic {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "49A8CF03F12E3553DCC23BB27643EAFC", hash_generated_method = "49A8CF03F12E3553DCC23BB27643EAFC")
        public Italic ()
        {
            
        }


    }


    
    private static class Underline {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "84D51255F87B8DD26833841AC6851E69", hash_generated_method = "84D51255F87B8DD26833841AC6851E69")
        public Underline ()
        {
            
        }


    }


    
    private static class Big {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "273608B63D858A3552D83E6F68A870F3", hash_generated_method = "273608B63D858A3552D83E6F68A870F3")
        public Big ()
        {
            
        }


    }


    
    private static class Small {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "30BB2E22576FED131404001997B90E83", hash_generated_method = "30BB2E22576FED131404001997B90E83")
        public Small ()
        {
            
        }


    }


    
    private static class Monospace {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "9E34A0C6710AE2CB78083EA433BD9375", hash_generated_method = "9E34A0C6710AE2CB78083EA433BD9375")
        public Monospace ()
        {
            
        }


    }


    
    private static class Blockquote {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "8510635EE940E5512FA9DD7C2C1B8599", hash_generated_method = "8510635EE940E5512FA9DD7C2C1B8599")
        public Blockquote ()
        {
            
        }


    }


    
    private static class Super {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "7F9EC2B6EDB6C576D6E7F20FD0DA4CCE", hash_generated_method = "7F9EC2B6EDB6C576D6E7F20FD0DA4CCE")
        public Super ()
        {
            
        }


    }


    
    private static class Sub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_method = "35CBF4C3F1CE0FC70451AFA9D19DB301", hash_generated_method = "35CBF4C3F1CE0FC70451AFA9D19DB301")
        public Sub ()
        {
            
        }


    }


    
    private static class Font {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.985 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "2C22DB162080CAE82C8D78A913DED9F7")

        public String mColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_field = "001A605783B748C535B6127A31F8F3EE", hash_generated_field = "9EF83681A7C49CB0E73C741AE3D0F05C")

        public String mFace;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_method = "C4B068F2F67D5AD4645AF1A9761F50CA", hash_generated_method = "0045DC1451596B8D8072989C438E2861")
        public  Font(String color, String face) {
            mColor = color;
            mFace = face;
            
            
            
        }

        
    }


    
    private static class Href {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_field = "CE33A8F3A41D743FE3E46C5E1C560A65", hash_generated_field = "2F16E5D3AF055919B45CF87232A38369")

        public String mHref;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_method = "1859394720661AA4B03D475EFD821F3A", hash_generated_method = "41EF2A9AC6A4FA312215BBCF14E58CAD")
        public  Href(String href) {
            mHref = href;
            
            
        }

        
    }


    
    private static class Header {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_field = "D3512852EA3D6B78A96B5192CDA7B029", hash_generated_field = "75109DE7AA3B41B03299C7AED8804A2F")

        private int mLevel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_method = "9C6EFC5AFAADDC937EF8FD6D30D1EF2D", hash_generated_method = "19FC55A0458E0C1D397B9A48B86FB54E")
        public  Header(int level) {
            mLevel = level;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_field = "D49A5EA828DDE4A015E6CB159896312A", hash_generated_field = "86AF0AEED37DBA73030BAFAE6316F8A7")

    private static final float[] HEADER_SIZES = {
        1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1f,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.986 -0400", hash_original_field = "5289A74433A08D80C65F1716485A5C4F", hash_generated_field = "B4FEF6E9838FF422A3FE4BD8FF30796B")

    private static HashMap<String,Integer> COLORS = buildColorMap();
}

