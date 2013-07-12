package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.004 -0400", hash_original_field = "83878C91171338902E0FE0FB97A8C47A", hash_generated_field = "78E68994DDB38DACD0C64DDC4B780EA5")

    DERInteger p;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.004 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "6AC8943BCF79B204F433F003E517CC05")

    DERInteger q;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.004 -0400", hash_original_field = "B2F5FF47436671B6E533D8DC3614845D", hash_generated_field = "5A4DB2BF53400ABF311DC12A3223BB24")

    DERInteger g;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.005 -0400", hash_original_method = "81ED473C328949571168B755965D24F0", hash_generated_method = "D2DABC7A8780AAD8CD87320B56EAB45B")
    public  DSAParameter(
        BigInteger  p,
        BigInteger  q,
        BigInteger  g) {
        this.p = new DERInteger(p);
        this.q = new DERInteger(q);
        this.g = new DERInteger(g);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.007 -0400", hash_original_method = "B573F82854284864B5E2E05C2136F7B9", hash_generated_method = "BCAA2A8C525F76800E272B90B0EF4964")
    public  DSAParameter(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
    if(seq.size() != 3)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_32728378 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_32728378.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_32728378;
        } 
        Enumeration e = seq.getObjects();
        p = DERInteger.getInstance(e.nextElement());
        q = DERInteger.getInstance(e.nextElement());
        g = DERInteger.getInstance(e.nextElement());
        
        
        
            
        
        
        
        
        
    }

    
        public static DSAParameter getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static DSAParameter getInstance(
        Object obj) {
        if(obj == null || obj instanceof DSAParameter) 
        {
            return (DSAParameter)obj;
        }
        if(obj instanceof ASN1Sequence) 
        {
            return new DSAParameter((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("Invalid DSAParameter: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.008 -0400", hash_original_method = "AD374264AA86AF8C15D476F74BF4E38F", hash_generated_method = "A0B064D98FDFF0A821891D5642A63F10")
    public BigInteger getP() {
BigInteger var3EF426B4E1F2501E96AD21D32A3B62C4_1035507372 =         p.getPositiveValue();
        var3EF426B4E1F2501E96AD21D32A3B62C4_1035507372.addTaint(taint);
        return var3EF426B4E1F2501E96AD21D32A3B62C4_1035507372;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.008 -0400", hash_original_method = "37C66EC3EBD32781416A0E32DB299F24", hash_generated_method = "55135656B1696F14202E3D0535B54BB8")
    public BigInteger getQ() {
BigInteger varCC858F5C6E76A5B6A466839CC6EE2CF8_194992855 =         q.getPositiveValue();
        varCC858F5C6E76A5B6A466839CC6EE2CF8_194992855.addTaint(taint);
        return varCC858F5C6E76A5B6A466839CC6EE2CF8_194992855;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.008 -0400", hash_original_method = "76F261BBDCDDE10636E0B2FE4E543575", hash_generated_method = "7E754BC25A6553AF05D39DA9615CDDCC")
    public BigInteger getG() {
BigInteger varAF2148D9A6BFAF217D996B041348DFDA_1685854585 =         g.getPositiveValue();
        varAF2148D9A6BFAF217D996B041348DFDA_1685854585.addTaint(taint);
        return varAF2148D9A6BFAF217D996B041348DFDA_1685854585;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.009 -0400", hash_original_method = "07D924177C8A847E61F30C74ABF9090B", hash_generated_method = "7D7343CCA58A34E26B6CDFEBB4BD0A40")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(p);
        v.add(q);
        v.add(g);
DERObject var0B338F106E3279986C87B595B0F4A439_1277013627 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1277013627.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1277013627;
        
        
        
        
        
        
    }

    
}

