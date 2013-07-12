package org.bouncycastle.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DataLengthException extends RuntimeCryptoException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.782 -0400", hash_original_method = "FC0834C19CF17037D683010F152D90BB", hash_generated_method = "A3B22023B871FEE196A5F978F598E189")
    public  DataLengthException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.782 -0400", hash_original_method = "DC74BD7370354E956783B762D3A498AE", hash_generated_method = "8825DFBF11F788E13B04C37E19C59FC9")
    public  DataLengthException(
        String  message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
}

