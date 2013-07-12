package android.view.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class AnticipateInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.727 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.728 -0400", hash_original_method = "7C2506D70A86643AB33B7796EA331F9D", hash_generated_method = "761E0AC6C5BE23250969F07445914E84")
    public  AnticipateInterpolator() {
        mTension = 2.0f;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.728 -0400", hash_original_method = "9BAE6E66C77EF37188591BAA368F1B92", hash_generated_method = "41BB8ADF848B4D75A305C8076C5221D1")
    public  AnticipateInterpolator(float tension) {
        mTension = tension;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.728 -0400", hash_original_method = "82BFA8AC47DF9DDA6D8E3F7FE8B02F6B", hash_generated_method = "904814DD998FA5C8676C061F993C9AA7")
    public  AnticipateInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.AnticipateInterpolator);
        mTension =
                a.getFloat(com.android.internal.R.styleable.AnticipateInterpolator_tension, 2.0f);
        a.recycle();
        
        
                
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.729 -0400", hash_original_method = "708C87963D95E01AE56D23D7408FFDE5", hash_generated_method = "8E029E600F004A3223585306FE244862")
    public float getInterpolation(float t) {
        addTaint(t);
        float var6BD61A0C8E974A43B4F77DB44E0C2B3B_1288734190 = (t * t * ((mTension + 1) * t - mTension));
                float var546ADE640B6EDFBC8A086EF31347E768_27784230 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_27784230;
        
        
    }

    
}

