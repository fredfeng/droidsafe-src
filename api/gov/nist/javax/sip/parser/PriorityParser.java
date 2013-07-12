package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import gov.nist.core.*;
import java.text.ParseException;

public class PriorityParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.461 -0400", hash_original_method = "3761C7DAE2C27B7066194088DE84B020", hash_generated_method = "9BE707ABFEAC5474F38DAD743E30A97D")
    public  PriorityParser(String priority) {
        super(priority);
        addTaint(priority.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.462 -0400", hash_original_method = "2FA6157C959FDD566822D2465D62D365", hash_generated_method = "12837E715683B7A7200A42CDA1F47E2E")
    protected  PriorityParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.463 -0400", hash_original_method = "9ECC1E43903CC22F0322E70EF9078767", hash_generated_method = "8016C8F888E9904570BBC288B08B5994")
    public SIPHeader parse() throws ParseException {
    if(debug)        
        dbg_enter("PriorityParser.parse");
        Priority priority = new Priority();
        try 
        {
            headerName(TokenTypes.PRIORITY);
            priority.setHeaderName(SIPHeaderNames.PRIORITY);
            this.lexer.SPorHT();
            priority.setPriority(this.lexer.ttokenSafe());
            this.lexer.SPorHT();
            this.lexer.match('\n');
SIPHeader var9141C1D2D467F4F6FF150C27DE3F01A3_944671166 =             priority;
            var9141C1D2D467F4F6FF150C27DE3F01A3_944671166.addTaint(taint);
            return var9141C1D2D467F4F6FF150C27DE3F01A3_944671166;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("PriorityParser.parse");
        } 
        
        
            
        
        
            
            
            
            
            
            
            
        
            
                
        
    }

    
        public static void main(String args[]) throws ParseException {
        String p[] = {
            "Priority: 8;a\n"
            };
        for (int i = 0; i < p.length; i++ ) {
        PriorityParser parser =
          new PriorityParser(p[i]);
        Priority prio= (Priority) parser.parse();
        System.out.println("encoded = " + prio.encode());
    }
    }

    
}

