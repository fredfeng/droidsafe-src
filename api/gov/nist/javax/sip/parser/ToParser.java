package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.address.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;

public class ToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.111 -0400", hash_original_method = "C8F2641055D76DBC203D7F98D786CB89", hash_generated_method = "88793D27788E97D3A4BDFC1C76A5832E")
    public  ToParser(String to) {
        super(to);
        addTaint(to.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.112 -0400", hash_original_method = "F0F7A8E65FEB47CEDC2639617287C00D", hash_generated_method = "417100FA4B28FEC2CE41545F8246BD45")
    protected  ToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.112 -0400", hash_original_method = "9D8B9A06C15E6D7FEEEC143ED65417C6", hash_generated_method = "56AD002D41CC2338DA3544B6131B33DE")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.TO);
        To to = new To();
        super.parse(to);
        this.lexer.match('\n');
SIPHeader var26633470D0AEBDC975B85A12020B47EA_2086129825 =         to;
        var26633470D0AEBDC975B85A12020B47EA_2086129825.addTaint(taint);
        return var26633470D0AEBDC975B85A12020B47EA_2086129825;
        
        
        
        
        
        
    }

    
}

