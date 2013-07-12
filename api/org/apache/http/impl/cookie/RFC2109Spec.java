package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookiePathComparator;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;

public class RFC2109Spec extends CookieSpecBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.786 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.787 -0400", hash_original_field = "1DC8E1B30B1B1279E15BB73B4101C43C", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")

    private boolean oneHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.788 -0400", hash_original_method = "12A896738D34FDBE49C7AA7970841F81", hash_generated_method = "273A43F3CFB68529060DC84790B098DD")
    public  RFC2109Spec(final String[] datepatterns, boolean oneHeader) {
        super();
    if(datepatterns != null)        
        {
            this.datepatterns = datepatterns.clone();
        } 
        else
        {
            this.datepatterns = DATE_PATTERNS;
        } 
        this.oneHeader = oneHeader;
        registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2109VersionHandler());
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2109DomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        
        
            
        
            
        
        
        
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.788 -0400", hash_original_method = "2854FB63A9A4FFE7625656D05E6D284B", hash_generated_method = "704B85C0725CE4A0C7BEC650B2E2F3CA")
    public  RFC2109Spec() {
        this(null, false);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.788 -0400", hash_original_method = "FE34B3C1E0CEB3E28830FDDDCE3EDCF4", hash_generated_method = "069CC4ECC7A5CC0D74FF7372FA2C3433")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(header.getTaint());
    if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_714418736 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_714418736.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_714418736;
        } 
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_912317674 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_912317674.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_912317674;
        } 
        HeaderElement[] elems = header.getElements();
List<Cookie> var244203BCE4724537DC84FE61D4419CE6_1423257693 =         parse(elems, origin);
        var244203BCE4724537DC84FE61D4419CE6_1423257693.addTaint(taint);
        return var244203BCE4724537DC84FE61D4419CE6_1423257693;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.789 -0400", hash_original_method = "FA8C9B830274A9DE10C31E9A8EA08163", hash_generated_method = "42F0522CAE1E9D97AD183A00D5744CAD")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_575304840 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_575304840.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_575304840;
        } 
        String name = cookie.getName();
    if(name.indexOf(' ') != -1)        
        {
            MalformedCookieException varA077DEAC3DA0DB270BE2280A8BDE44CD_721664038 = new MalformedCookieException("Cookie name may not contain blanks");
            varA077DEAC3DA0DB270BE2280A8BDE44CD_721664038.addTaint(taint);
            throw varA077DEAC3DA0DB270BE2280A8BDE44CD_721664038;
        } 
    if(name.startsWith("$"))        
        {
            MalformedCookieException var73044899A76FC44930121E2E2EE9F5ED_585932969 = new MalformedCookieException("Cookie name may not start with $");
            var73044899A76FC44930121E2E2EE9F5ED_585932969.addTaint(taint);
            throw var73044899A76FC44930121E2E2EE9F5ED_585932969;
        } 
        super.validate(cookie, origin);
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.790 -0400", hash_original_method = "67F48779D521683257B0CC0E930A401A", hash_generated_method = "83EDB9734CACB883EF63C9CD51364E89")
    public List<Header> formatCookies(List<Cookie> cookies) {
        addTaint(cookies.getTaint());
    if(cookies == null)        
        {
            IllegalArgumentException varF8FD3AA86899D4A0D763F37D49D2DC0B_106015017 = new IllegalArgumentException("List of cookies may not be null");
            varF8FD3AA86899D4A0D763F37D49D2DC0B_106015017.addTaint(taint);
            throw varF8FD3AA86899D4A0D763F37D49D2DC0B_106015017;
        } 
    if(cookies.isEmpty())        
        {
            IllegalArgumentException varA9E78185ACB38B15D24741774F0DBD8F_1199547872 = new IllegalArgumentException("List of cookies may not be empty");
            varA9E78185ACB38B15D24741774F0DBD8F_1199547872.addTaint(taint);
            throw varA9E78185ACB38B15D24741774F0DBD8F_1199547872;
        } 
    if(cookies.size() > 1)        
        {
            cookies = new ArrayList<Cookie>(cookies);
            Collections.sort(cookies, PATH_COMPARATOR);
        } 
    if(this.oneHeader)        
        {
List<Header> var0270C332E4B4942F44FC01D14E1998FA_405171596 =             doFormatOneHeader(cookies);
            var0270C332E4B4942F44FC01D14E1998FA_405171596.addTaint(taint);
            return var0270C332E4B4942F44FC01D14E1998FA_405171596;
        } 
        else
        {
List<Header> var59734256327096CDB0D6F953D783862E_392616167 =             doFormatManyHeaders(cookies);
            var59734256327096CDB0D6F953D783862E_392616167.addTaint(taint);
            return var59734256327096CDB0D6F953D783862E_392616167;
        } 
        
        
            
        
        
            
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.791 -0400", hash_original_method = "13FFFC492D1247BC18ED6817446ED518", hash_generated_method = "2649FF306994951711A68AF12CDCE876")
    private List<Header> doFormatOneHeader(final List<Cookie> cookies) {
        addTaint(cookies.getTaint());
        int version = Integer.MAX_VALUE;
for(Cookie cookie : cookies)
        {
    if(cookie.getVersion() < version)            
            {
                version = cookie.getVersion();
            } 
        } 
        CharArrayBuffer buffer = new CharArrayBuffer(40 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(version));
for(Cookie cooky : cookies)
        {
            buffer.append("; ");
            Cookie cookie = cooky;
            formatCookieAsVer(buffer, cookie, version);
        } 
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
List<Header> var6937E37BAD8D53F9D49A0E32C69A3A2C_1776160974 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_1776160974.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_1776160974;
        
        
        
            
                
            
        
        
        
        
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.791 -0400", hash_original_method = "8AE6C62AD6B7A2305FE4DC1EC3AC9430", hash_generated_method = "1889F2D982278D365FCF9E3CF861233B")
    private List<Header> doFormatManyHeaders(final List<Cookie> cookies) {
        addTaint(cookies.getTaint());
        List<Header> headers = new ArrayList<Header>(cookies.size());
for(Cookie cookie : cookies)
        {
            int version = cookie.getVersion();
            CharArrayBuffer buffer = new CharArrayBuffer(40);
            buffer.append("Cookie: ");
            buffer.append("$Version=");
            buffer.append(Integer.toString(version));
            buffer.append("; ");
            formatCookieAsVer(buffer, cookie, version);
            headers.add(new BufferedHeader(buffer));
        } 
List<Header> var6937E37BAD8D53F9D49A0E32C69A3A2C_1422161940 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_1422161940.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_1422161940;
        
        
        
            
            
            
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.792 -0400", hash_original_method = "06F97D44B0AB130D85C55056AFD5C23B", hash_generated_method = "982FF44A9FF37AD5FC4DA92E9661BFB1")
    protected void formatParamAsVer(final CharArrayBuffer buffer, 
            final String name, final String value, int version) {
        addTaint(version);
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        addTaint(buffer.getTaint());
        buffer.append(name);
        buffer.append("=");
    if(value != null)        
        {
    if(version > 0)            
            {
                buffer.append('\"');
                buffer.append(value);
                buffer.append('\"');
            } 
            else
            {
                buffer.append(value);
            } 
        } 
        
        
        
        
            
                
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.792 -0400", hash_original_method = "FCDC82ACC7F918D2268FA007BF779A17", hash_generated_method = "3E6BE87378A6EEDC523FFE15DF9402AE")
    protected void formatCookieAsVer(final CharArrayBuffer buffer, 
            final Cookie cookie, int version) {
        addTaint(version);
        addTaint(cookie.getTaint());
        addTaint(buffer.getTaint());
        formatParamAsVer(buffer, cookie.getName(), cookie.getValue(), version);
    if(cookie.getPath() != null)        
        {
    if(cookie instanceof ClientCookie 
                    && ((ClientCookie) cookie).containsAttribute(ClientCookie.PATH_ATTR))            
            {
                buffer.append("; ");
                formatParamAsVer(buffer, "$Path", cookie.getPath(), version);
            } 
        } 
    if(cookie.getDomain() != null)        
        {
    if(cookie instanceof ClientCookie 
                    && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR))            
            {
                buffer.append("; ");
                formatParamAsVer(buffer, "$Domain", cookie.getDomain(), version);
            } 
        } 
        
        
        
            
                    
                
                
            
        
        
            
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.793 -0400", hash_original_method = "48398E54A721F2ABBD2AD2C5ED75FBF5", hash_generated_method = "E061362386933014D87EEAB9AF603A00")
    public int getVersion() {
        int varC4CA4238A0B923820DCC509A6F75849B_1050040717 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285359784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285359784;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.793 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "6930FCECFAE01EF64C6AB171340A288E")
    public Header getVersionHeader() {
Header var540C13E9E156B687226421B24F2DF178_164624287 =         null;
        var540C13E9E156B687226421B24F2DF178_164624287.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_164624287;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.793 -0400", hash_original_field = "ABFA51F6E4B6F45C0F10C82A927D071D", hash_generated_field = "858B7D4610C97949773EF50E93F05188")

    private final static CookiePathComparator PATH_COMPARATOR = new CookiePathComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.793 -0400", hash_original_field = "E3CDA0E427D73051E5F5FE32B9272277", hash_generated_field = "FBD8DD687539DFF4AAFA7EAA45AC1BE6")

    private final static String[] DATE_PATTERNS = {
        DateUtils.PATTERN_RFC1123,
        DateUtils.PATTERN_RFC1036,
        DateUtils.PATTERN_ASCTIME 
    };
}

