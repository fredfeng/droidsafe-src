package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AccelerateInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.480 -0400", hash_original_field = "9AF4F81F21F540E9EDADA9926D5D915A", hash_generated_field = "C4B60CAF58795A5FD80295DCE69373D7")

    private float mFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.480 -0400", hash_original_field = "FBC270DE6A296B0EB716CD6DD0CC28E2", hash_generated_field = "E32BD9A569BB931AE42B2AB10166121F")

    private double mDoubleFactor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.481 -0400", hash_original_method = "6B066D2B0A6275C71F94C50A6808FEFE", hash_generated_method = "F4C76F6A7360596A87957076806A582C")
    public  AccelerateInterpolator() {
        mFactor = 1.0f;
        mDoubleFactor = 2.0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.481 -0400", hash_original_method = "94059E5CBD2536EA402F0EA752CA0B91", hash_generated_method = "126B53B6E870C70FE373A6F1F10D530B")
    public  AccelerateInterpolator(float factor) {
        mFactor = factor;
        mDoubleFactor = 2 * mFactor;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.482 -0400", hash_original_method = "E776590D91ABBE218804FDD3622828FA", hash_generated_method = "5FFEF247DF75964B76CC6227F1486FF7")
    public  AccelerateInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.AccelerateInterpolator);
        mFactor = a.getFloat(com.android.internal.R.styleable.AccelerateInterpolator_factor, 1.0f);
        mDoubleFactor = 2 * mFactor;
        a.recycle();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.482 -0400", hash_original_method = "8D8C7C748A85E1C7007F595C7B08B241", hash_generated_method = "2FE1BB4DC8398797CAB3F8898A58BD87")
    public float getInterpolation(float input) {
        addTaint(input);
    if(mFactor == 1.0f)        
        {
            float var882BDEA7773A3C8A17444B90E648DBEC_732980518 = (input * input);
                        float var546ADE640B6EDFBC8A086EF31347E768_1171695250 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1171695250;
        } 
        else
        {
            float var9818D6E8E33B7E9F5F48A6DDF22A4C5C_212516167 = ((float)Math.pow(input, mDoubleFactor));
                        float var546ADE640B6EDFBC8A086EF31347E768_572901828 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_572901828;
        } 
        
        
            
        
            
        
    }

    
}

