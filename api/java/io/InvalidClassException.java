package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class InvalidClassException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.910 -0400", hash_original_field = "26B2A720F7B8C9BD8D3999C52DA409D0", hash_generated_field = "B0C75E444ABFD30811DA4022885A4FE7")

    public String classname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.911 -0400", hash_original_method = "EFF9B20162E74D1DBB80ACE44E70A573", hash_generated_method = "F8B3DAD56180F56E19D0C8EF9347D6B4")
    public  InvalidClassException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.912 -0400", hash_original_method = "A0014C5B63B7954D0D217FAB7EAA1F21", hash_generated_method = "63D5E8FE9E01F9230EB120DE904250B6")
    public  InvalidClassException(String className, String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        this.classname = className;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.915 -0400", hash_original_method = "F4D165DC6F6D9B89EF49B0E2E4445877", hash_generated_method = "75502DB884278CED86B53C1F90092606")
    @Override
    public String getMessage() {
        String msg = super.getMessage();
    if(classname != null)        
        {
            msg = classname + "; " + msg;
        } 
String varEDC5B72465A7F0BEE288689BCB1DD141_1256760047 =         msg;
        varEDC5B72465A7F0BEE288689BCB1DD141_1256760047.addTaint(taint);
        return varEDC5B72465A7F0BEE288689BCB1DD141_1256760047;
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.916 -0400", hash_original_field = "72D7A703CD0FB4057452DEA0641D5BCD", hash_generated_field = "D4E2FCFAAD906D95CB6BCEB015D3083F")

    private static final long serialVersionUID = -4333316296251054416L;
}

