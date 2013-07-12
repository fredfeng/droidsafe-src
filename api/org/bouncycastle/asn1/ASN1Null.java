package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class ASN1Null extends ASN1Object {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.596 -0400", hash_original_method = "D0FE59B1A9D3F66BFB745D7E961EAD28", hash_generated_method = "14E33D4578D52777E859D4C899DF0B5C")
      ASN1Null() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.596 -0400", hash_original_method = "8B33772CC706A3F76B2A9FE6D8E11F7C", hash_generated_method = "1FA3E1C70B4732DEC5F11E45781D24D1")
    public int hashCode() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1707003316 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825488117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825488117;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.597 -0400", hash_original_method = "7109287BD38944677651878D40817EF4", hash_generated_method = "B0BEEC52EFF914451540920B3B6C5720")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
    if(!(o instanceof ASN1Null))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1246458038 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_445788663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_445788663;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_229491418 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483770609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483770609;
        
        
        
            
        
        
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.597 -0400", hash_original_method = "BBD03FB924B892CEE23A9F439923567F", hash_generated_method = "F64FD199D5E3ED82CD8F080ED1F20D6F")
    public String toString() {
String var33D29D752C3932DEA56761DD803BA922_722173890 =         "NULL";
        var33D29D752C3932DEA56761DD803BA922_722173890.addTaint(taint);
        return var33D29D752C3932DEA56761DD803BA922_722173890;
        
        
    }

    
}

