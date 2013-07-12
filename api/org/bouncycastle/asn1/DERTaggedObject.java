package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERTaggedObject extends ASN1TaggedObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.208 -0400", hash_original_method = "B8C39F3F8493AE66929508E836F6CEF7", hash_generated_method = "2DE9FE1746D2B15EB2F0349CD8D253B8")
    public  DERTaggedObject(
        int             tagNo,
        DEREncodable    obj) {
        super(tagNo, obj);
        addTaint(obj.getTaint());
        addTaint(tagNo);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.208 -0400", hash_original_method = "D15475FEA6616F6A5D6AAE500D0E135A", hash_generated_method = "6CD5A4316BA3B876E55EC2BC08CDDB0E")
    public  DERTaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj) {
        super(explicit, tagNo, obj);
        addTaint(obj.getTaint());
        addTaint(tagNo);
        addTaint(explicit);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.209 -0400", hash_original_method = "14B57626E7341DE57616D6DE76633AEC", hash_generated_method = "047746C21F73F9D85EBAAF772E64E012")
    public  DERTaggedObject(
        int             tagNo) {
        super(false, tagNo, new DERSequence());
        addTaint(tagNo);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.209 -0400", hash_original_method = "B5277AF27C85DE4A4669302802507303", hash_generated_method = "B8293AB8DFF12CDDDCC20BEA7E098EE6")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
    if(!empty)        
        {
            byte[] bytes = obj.getDERObject().getEncoded(DER);
    if(explicit)            
            {
                out.writeEncoded(CONSTRUCTED | TAGGED, tagNo, bytes);
            } 
            else
            {
                int flags;
    if((bytes[0] & CONSTRUCTED) != 0)                
                {
                    flags = CONSTRUCTED | TAGGED;
                } 
                else
                {
                    flags = TAGGED;
                } 
                out.writeTag(flags, tagNo);
                out.write(bytes, 1, bytes.length - 1);
            } 
        } 
        else
        {
            out.writeEncoded(CONSTRUCTED | TAGGED, tagNo, ZERO_BYTES);
        } 
        
        
        
            
            
            
                
            
            
            
                
                
                
                    
                
                
                
                    
                
                
                
            
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.210 -0400", hash_original_field = "D91077190958F29EB6E06E2F51FAE62D", hash_generated_field = "DC855D7D38FB2BD504042CC7CEABD828")

    private static final byte[] ZERO_BYTES = new byte[0];
}

