package org.apache.harmony.luni.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class TimezoneGetter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.231 -0400", hash_original_method = "66ED1F8E1E851198705C6DFD8EC10BBB", hash_generated_method = "66ED1F8E1E851198705C6DFD8EC10BBB")
    public TimezoneGetter ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static TimezoneGetter getInstance() {
        return instance;
    }

    
        public static void setInstance(TimezoneGetter getter) {
        if (instance != null) {
            throw new UnsupportedOperationException("TimezoneGetter instance already set");
        }
        instance = getter;
    }

    
    public abstract String getId();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.232 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "D3AAD2C19E68DBB13BF532AFF4D3C58C")

    private static TimezoneGetter instance;
}

