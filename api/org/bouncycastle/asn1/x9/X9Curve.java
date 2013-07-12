package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;

public class X9Curve extends ASN1Encodable implements X9ObjectIdentifiers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.474 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "D4FD3D236F6822F3201F264EA949068E")

    private ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.474 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "84A0CB03E1AA0B2A11E3988D98BBE452")

    private byte[] seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.474 -0400", hash_original_field = "C2288003BB5201930540DA624FE9B669", hash_generated_field = "E3338F0376BEF793D592DF0C27082DD0")

    private DERObjectIdentifier fieldIdentifier = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.474 -0400", hash_original_method = "D6C787E2A4803225F35FA6BCE1822130", hash_generated_method = "9C77687FAE312DDD695CEE5DA2B770F5")
    public  X9Curve(
        ECCurve     curve) {
        this.curve = curve;
        this.seed = null;
        setFieldIdentifier();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.474 -0400", hash_original_method = "3B7C14B5F62450195FF0D6E781874500", hash_generated_method = "520BE3AA222231447B5DC8D30ABB9A87")
    public  X9Curve(
        ECCurve     curve,
        byte[]      seed) {
        this.curve = curve;
        this.seed = seed;
        setFieldIdentifier();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.475 -0400", hash_original_method = "7B136525ED7EAC50EDEE818CB871C643", hash_generated_method = "F8E1C5ADB8C441E4E6094FF797F80A12")
    public  X9Curve(
        X9FieldID     fieldID,
        ASN1Sequence  seq) {
        fieldIdentifier = fieldID.getIdentifier();
    if(fieldIdentifier.equals(prime_field))        
        {
            BigInteger p = ((DERInteger)fieldID.getParameters()).getValue();
            X9FieldElement x9A = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(0));
            X9FieldElement x9B = new X9FieldElement(p, (ASN1OctetString)seq.getObjectAt(1));
            curve = new ECCurve.Fp(p, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
        } 
        else
        {
    if(fieldIdentifier.equals(characteristic_two_field))            
            {
                DERSequence parameters = (DERSequence)fieldID.getParameters();
                int m = ((DERInteger)parameters.getObjectAt(0)).getValue().
                    intValue();
                DERObjectIdentifier representation = (DERObjectIdentifier)parameters.getObjectAt(1);
                int k1 = 0;
                int k2 = 0;
                int k3 = 0;
    if(representation.equals(tpBasis))                
                {
                    k1 = ((DERInteger)parameters.getObjectAt(2)).getValue().
                        intValue();
                } 
                else
                {
                    DERSequence pentanomial = (DERSequence)parameters.getObjectAt(2);
                    k1 = ((DERInteger)pentanomial.getObjectAt(0)).getValue().
                        intValue();
                    k2 = ((DERInteger)pentanomial.getObjectAt(1)).getValue().
                        intValue();
                    k3 = ((DERInteger)pentanomial.getObjectAt(2)).getValue().
                        intValue();
                } 
                X9FieldElement x9A = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(0));
                X9FieldElement x9B = new X9FieldElement(m, k1, k2, k3, (ASN1OctetString)seq.getObjectAt(1));
                curve = new ECCurve.F2m(m, k1, k2, k3, x9A.getValue().toBigInteger(), x9B.getValue().toBigInteger());
            } 
        } 
    if(seq.size() == 3)        
        {
            seed = ((DERBitString)seq.getObjectAt(2)).getBytes();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.475 -0400", hash_original_method = "D736F484B6800931FE72576618335766", hash_generated_method = "8F8562D02FAC5353A01979F5EEB6A0EB")
    private void setFieldIdentifier() {
    if(curve instanceof ECCurve.Fp)        
        {
            fieldIdentifier = prime_field;
        } 
        else
    if(curve instanceof ECCurve.F2m)        
        {
            fieldIdentifier = characteristic_two_field;
        } 
        else
        {
            IllegalArgumentException var802FC9E668045A7AE36679019DFEE10D_2017748659 = new IllegalArgumentException("This type of ECCurve is not "
                    + "implemented");
            var802FC9E668045A7AE36679019DFEE10D_2017748659.addTaint(taint);
            throw var802FC9E668045A7AE36679019DFEE10D_2017748659;
        } 
        
        
        
            
        
        
        
            
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.475 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "2251FBF1CCF24832463B6AA1C5E11A0A")
    public ECCurve getCurve() {
ECCurve varCB08C04A7A1DB77E60E6F93B4C766067_852918609 =         curve;
        varCB08C04A7A1DB77E60E6F93B4C766067_852918609.addTaint(taint);
        return varCB08C04A7A1DB77E60E6F93B4C766067_852918609;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.476 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "5C49C35F030AA0C86C6A6F355281C057")
    public byte[] getSeed() {
        byte[] varFE4C0F30AA359C41D9F9A5F69C8C4192_38424976 = (seed);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_981956619 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_981956619;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.476 -0400", hash_original_method = "FE4C71C21A5F26496E8390DAB2BE9299", hash_generated_method = "CE1DE703572355A20F013CC58B7202C6")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
    if(fieldIdentifier.equals(prime_field))        
        {
            v.add(new X9FieldElement(curve.getA()).getDERObject());
            v.add(new X9FieldElement(curve.getB()).getDERObject());
        } 
        else
    if(fieldIdentifier.equals(characteristic_two_field))        
        {
            v.add(new X9FieldElement(curve.getA()).getDERObject());
            v.add(new X9FieldElement(curve.getB()).getDERObject());
        } 
    if(seed != null)        
        {
            v.add(new DERBitString(seed));
        } 
DERObject var0B338F106E3279986C87B595B0F4A439_959157593 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_959157593.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_959157593;
        
        
        
        
            
            
        
        
        
            
            
        
        
        
            
        
        
    }

    
}

