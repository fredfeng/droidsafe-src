package android.graphics;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MaskFilter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.299 -0400", hash_original_field = "7E2E7BFEC42581BDE25254C4BB512478", hash_generated_field = "1353DF0D3FEF59358BA81F3F4AC59875")

    int native_instance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.300 -0400", hash_original_method = "C1D6709FDC433FB6BE788CD4DDEC7BFF", hash_generated_method = "C1D6709FDC433FB6BE788CD4DDEC7BFF")
    public MaskFilter ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:18.300 -0400", hash_original_method = "CA9745465B207BED8177C430188A7C4B", hash_generated_method = "0F8C7E32A99795A8E0AEE47F785754CE")
    protected void finalize() throws Throwable {
        nativeDestructor(native_instance);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int native_filter) {
    }

    
}

