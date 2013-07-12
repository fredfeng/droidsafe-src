package javax.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CertificateEncodingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.236 -0400", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "9AF12C7C6EFC4619DBB2BD1EE3112CE5")
    public  CertificateEncodingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.237 -0400", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "C2D35BC07014BC3018532FA9B69AF7DE")
    public  CertificateEncodingException() {
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.237 -0400", hash_original_field = "DEEB62DF1D87842C4CFD50EADC007C04", hash_generated_field = "E640B75D9A9B871CE2BE02F61BBEA9DB")

    private static final long serialVersionUID = -8187642723048403470L;
}

