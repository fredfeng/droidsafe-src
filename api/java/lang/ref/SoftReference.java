package java.lang.ref;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SoftReference<T> extends Reference<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.856 -0400", hash_original_method = "580748AA620617AA151344F4D11AC7C2", hash_generated_method = "44400A0B733754D3D14DB23E92A5622F")
    public  SoftReference(T r) {
        super(r, null);
        addTaint(r.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.856 -0400", hash_original_method = "123F9816B0FED05FA5B253267B81F032", hash_generated_method = "0BADCB5FD00B80A2209DE81D65A457A0")
    public  SoftReference(T r, ReferenceQueue<? super T> q) {
        super(r, q);
        addTaint(q.getTaint());
        addTaint(r.getTaint());
        
    }

    
}

