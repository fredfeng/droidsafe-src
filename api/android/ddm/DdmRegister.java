package android.ddm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.dalvik.ddmc.DdmServer;
import android.util.Log;

public class DdmRegister {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.495 -0400", hash_original_method = "7B8C628EED4FBAEB3F2321039DB7D59A", hash_generated_method = "DF606A387D5DE4F2C61C8EFBABDB78F2")
    private  DdmRegister() {
        
    }

    
        public static void registerHandlers() {
        if (false)
            Log.v("ddm", "Registering DDM message handlers");
        DdmHandleHello.register();
        DdmHandleThread.register();
        DdmHandleHeap.register();
        DdmHandleNativeHeap.register();
        DdmHandleProfiling.register();
        DdmHandleExit.register();
        DdmServer.registrationComplete();
    }

    
}

