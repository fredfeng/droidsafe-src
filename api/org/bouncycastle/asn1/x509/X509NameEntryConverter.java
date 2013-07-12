package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.Strings;
import java.io.IOException;

public abstract class X509NameEntryConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.575 -0400", hash_original_method = "895CB1F94322718A75CF3FC7407A7622", hash_generated_method = "895CB1F94322718A75CF3FC7407A7622")
    public X509NameEntryConverter ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.577 -0400", hash_original_method = "0820E5B6790D0EF76EEAF699A8A71CD6", hash_generated_method = "2EAEB41E0AF83FBEEF56DD376F552DE8")
    protected DERObject convertHexEncoded(
        String  str,
        int     off) throws IOException {
        addTaint(off);
        addTaint(str.getTaint());
        str = Strings.toLowerCase(str);
        byte[] data = new byte[(str.length() - off) / 2];
for(int index = 0;index != data.length;index++)
        {
            char left = str.charAt((index * 2) + off);
            char right = str.charAt((index * 2) + off + 1);
    if(left < 'a')            
            {
                data[index] = (byte)((left - '0') << 4);
            } 
            else
            {
                data[index] = (byte)((left - 'a' + 10) << 4);
            } 
    if(right < 'a')            
            {
                data[index] |= (byte)(right - '0');
            } 
            else
            {
                data[index] |= (byte)(right - 'a' + 10);
            } 
        } 
        ASN1InputStream aIn = new ASN1InputStream(data);
DERObject var744C7B728C1BF7AC9370DA8D8B9598D6_1774561935 =         aIn.readObject();
        var744C7B728C1BF7AC9370DA8D8B9598D6_1774561935.addTaint(taint);
        return var744C7B728C1BF7AC9370DA8D8B9598D6_1774561935;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.578 -0400", hash_original_method = "499FF8BD25CE956701C5B1F46FEEC51A", hash_generated_method = "2B2C41BD20EC7BEA8A46FE0285C1D1A2")
    protected boolean canBePrintable(
        String  str) {
        addTaint(str.getTaint());
        boolean varF6C770A90D6BB561B31334BDADDD9A35_1264491093 = (DERPrintableString.isPrintableString(str));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979217496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979217496;
        
        
    }

    
    public abstract DERObject getConvertedValue(DERObjectIdentifier oid, String value);

    
}

