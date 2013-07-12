package android.os.storage;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class StorageEventListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.064 -0400", hash_original_method = "61076BC963620255AB850D9EEFFDEDA8", hash_generated_method = "61076BC963620255AB850D9EEFFDEDA8")
    public StorageEventListener ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.064 -0400", hash_original_method = "08B6588D85EC619CC2E0611C0812F3DA", hash_generated_method = "F3FE4A7A33440C9CE86D85B6EE7F350A")
    public void onUsbMassStorageConnectionChanged(boolean connected) {
        
        addTaint(connected);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.065 -0400", hash_original_method = "B80645FD27258B59A3B650E166B00E17", hash_generated_method = "4B5492CC2FD10AE6ACD5C5AA60669277")
    public void onStorageStateChanged(String path, String oldState, String newState) {
        
        addTaint(newState.getTaint());
        addTaint(oldState.getTaint());
        addTaint(path.getTaint());
        
    }

    
}

