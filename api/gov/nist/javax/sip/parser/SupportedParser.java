package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class SupportedParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.030 -0400", hash_original_method = "825F17E8D5A2A3E333D66101B84E14D2", hash_generated_method = "12D1D6A1FF5C12C3F1476BBA8E937853")
    public  SupportedParser(String supported) {
        super(supported);
        addTaint(supported.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.030 -0400", hash_original_method = "6DF629AC3F3B8D2B11653ABB66FFD43C", hash_generated_method = "BBF8FA0AF39F77794FFB58F84C4400DC")
    protected  SupportedParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.031 -0400", hash_original_method = "0C976477F7A22AE527BAA6379E244E6F", hash_generated_method = "0924E282AFD8762C583A8B03368856B8")
    public SIPHeader parse() throws ParseException {
        SupportedList supportedList = new SupportedList();
    if(debug)        
        dbg_enter("SupportedParser.parse");
        try 
        {
            headerName(TokenTypes.SUPPORTED);
            while
(lexer.lookAhead(0) != '\n')            
            {
                this.lexer.SPorHT();
                Supported supported = new Supported();
                supported.setHeaderName(SIPHeaderNames.SUPPORTED);
                this.lexer.match(TokenTypes.ID);
                Token token = lexer.getNextToken();
                supported.setOptionTag(token.getTokenValue());
                this.lexer.SPorHT();
                supportedList.add(supported);
                while
(lexer.lookAhead(0) == ',')                
                {
                    this.lexer.match(',');
                    this.lexer.SPorHT();
                    supported = new Supported();
                    this.lexer.match(TokenTypes.ID);
                    token = lexer.getNextToken();
                    supported.setOptionTag(token.getTokenValue());
                    this.lexer.SPorHT();
                    supportedList.add(supported);
                } 
            } 
        } 
        finally 
        {
    if(debug)            
            dbg_leave("SupportedParser.parse");
        } 
SIPHeader var81B93F9A8101C3978BA21B0223EF1130_787008537 =         supportedList;
        var81B93F9A8101C3978BA21B0223EF1130_787008537.addTaint(taint);
        return var81B93F9A8101C3978BA21B0223EF1130_787008537;
        
        
    }

    
}

