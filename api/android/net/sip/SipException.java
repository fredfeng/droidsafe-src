package android.net.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SipException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.323 -0400", hash_original_method = "2844FA66AE6BF3430E2D663113A5D509", hash_generated_method = "55BA8DDE2D4649EC43875D789C2CA939")
    public  SipException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.323 -0400", hash_original_method = "9795DB733321F498B81268F6E7181236", hash_generated_method = "E42819ACCDC57D85ECA3E0EEEEC55716")
    public  SipException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:28.324 -0400", hash_original_method = "0929D315124628FA3E72B5EC08F3DEFE", hash_generated_method = "6A0449E617514DC682B06451206764D1")
    public  SipException(String message, Throwable cause) {
        super(message, ((cause instanceof javax.sip.SipException)
                && (cause.getCause() != null))
                ? cause.getCause()
                : cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
}

