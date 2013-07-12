package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.PCalledPartyIDHeader;

public class PCalledPartyID extends gov.nist.javax.sip.header.AddressParametersHeader implements PCalledPartyIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.944 -0400", hash_original_method = "EDC402C5990746AE150AF00BD84032F6", hash_generated_method = "D9664EE33C8B96C805728CCB2FF4B2BE")
    public  PCalledPartyID(AddressImpl address) {
        super(NAME);
        addTaint(address.getTaint());
        this.address = address;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.944 -0400", hash_original_method = "D34D544F1730F850E33368222A05354C", hash_generated_method = "49A3F9AF22422791AFB5269749C297FA")
    public  PCalledPartyID() {
        super(CALLED_PARTY_ID);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.944 -0400", hash_original_method = "DD9AA0788424353442B0CFE218D97412", hash_generated_method = "5D76B1BC6A75494CC8339B3D7E45FB18")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer();
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(LESS_THAN);
        } 
        retval.append(address.encode());
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            retval.append(GREATER_THAN);
        } 
    if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_1902984818 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1902984818.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1902984818;
        
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.944 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "4CFACBA2BFEFDC28C44692F067104B6F")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_805490611 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_805490611.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_805490611;
        
        
    }

    
}

