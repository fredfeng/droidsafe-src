package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.719 -0400", hash_original_field = "678DB741D1B48B4477A490AEDCFD1EC9", hash_generated_field = "AD9BC78DBAEEEA7F3095C3D4235D31E3")

    private InputStream _in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.719 -0400", hash_original_field = "21B59360B06F124AC143A9061C12E7FA", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private int _limit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.720 -0400", hash_original_method = "DBA5BC9F59C3649B70C3A3387D909190", hash_generated_method = "4C60CF1DD9390047E8E1B385E4B3C5B1")
    public  ASN1StreamParser(
        InputStream in) {
        this(in, ASN1InputStream.findLimit(in));
        addTaint(in.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.720 -0400", hash_original_method = "6581181C0F10BA1424D0E617E42FF352", hash_generated_method = "64954578D1894591237E0A60FB444999")
    public  ASN1StreamParser(
        InputStream in,
        int         limit) {
        this._in = in;
        this._limit = limit;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.720 -0400", hash_original_method = "2384F9E8B7C9F8CABF70D53041DA5305", hash_generated_method = "D2F54DB8D0B7CB649116C7728344D0A5")
    public  ASN1StreamParser(
        byte[] encoding) {
        this(new ByteArrayInputStream(encoding), encoding.length);
        addTaint(encoding[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.721 -0400", hash_original_method = "C3E0BE0AC09DBB98B8E162DDEE686364", hash_generated_method = "BFB057C05A1AFD0ACBAD81016E1F50B7")
     DEREncodable readIndef(int tagValue) throws IOException {
        addTaint(tagValue);
switch(tagValue){
        case DERTags.EXTERNAL:
DEREncodable var1D4E6EB38EDC9BFC78BCA57BEEE300C6_1263925629 =         new DERExternalParser(this);
        var1D4E6EB38EDC9BFC78BCA57BEEE300C6_1263925629.addTaint(taint);
        return var1D4E6EB38EDC9BFC78BCA57BEEE300C6_1263925629;
        case DERTags.OCTET_STRING:
DEREncodable var671F4D920F601CC0BA0FCDA468430A91_2012556123 =         new BEROctetStringParser(this);
        var671F4D920F601CC0BA0FCDA468430A91_2012556123.addTaint(taint);
        return var671F4D920F601CC0BA0FCDA468430A91_2012556123;
        case DERTags.SEQUENCE:
DEREncodable varCCBBEFB56EE641A5B3956793B0A6B96B_1646212605 =         new BERSequenceParser(this);
        varCCBBEFB56EE641A5B3956793B0A6B96B_1646212605.addTaint(taint);
        return varCCBBEFB56EE641A5B3956793B0A6B96B_1646212605;
        case DERTags.SET:
DEREncodable varE346071D9A7CD17D4B60913654A94C97_422587233 =         new BERSetParser(this);
        varE346071D9A7CD17D4B60913654A94C97_422587233.addTaint(taint);
        return varE346071D9A7CD17D4B60913654A94C97_422587233;
        default:
        ASN1Exception varCAF52D6298D280BBB4771634F44A2C0F_786593936 = new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        varCAF52D6298D280BBB4771634F44A2C0F_786593936.addTaint(taint);
        throw varCAF52D6298D280BBB4771634F44A2C0F_786593936;
}
        
        
        
            
                
            
                
            
                
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.722 -0400", hash_original_method = "CAB584B2B56E52E14F26B47F81A64976", hash_generated_method = "7C678355AAA7DFFDEC49C158FA02DFD0")
     DEREncodable readImplicit(boolean constructed, int tag) throws IOException {
        addTaint(tag);
        addTaint(constructed);
    if(_in instanceof IndefiniteLengthInputStream)        
        {
    if(!constructed)            
            {
                IOException var0055B29725078D64828DFE2C61240180_1038971659 = new IOException("indefinite length primitive encoding encountered");
                var0055B29725078D64828DFE2C61240180_1038971659.addTaint(taint);
                throw var0055B29725078D64828DFE2C61240180_1038971659;
            } 
DEREncodable var77EDF699AE31BF30764DFA44A005E4C0_763022612 =             readIndef(tag);
            var77EDF699AE31BF30764DFA44A005E4C0_763022612.addTaint(taint);
            return var77EDF699AE31BF30764DFA44A005E4C0_763022612;
        } 
    if(constructed)        
        {
switch(tag){
            case DERTags.SET:
DEREncodable var22F42FB615D84EC4C182518AB01A30C1_314250497 =             new DERSetParser(this);
            var22F42FB615D84EC4C182518AB01A30C1_314250497.addTaint(taint);
            return var22F42FB615D84EC4C182518AB01A30C1_314250497;
            case DERTags.SEQUENCE:
DEREncodable var5565804631FCA79E3EFA6DC7084D7558_2019105171 =             new DERSequenceParser(this);
            var5565804631FCA79E3EFA6DC7084D7558_2019105171.addTaint(taint);
            return var5565804631FCA79E3EFA6DC7084D7558_2019105171;
            case DERTags.OCTET_STRING:
DEREncodable var671F4D920F601CC0BA0FCDA468430A91_809810269 =             new BEROctetStringParser(this);
            var671F4D920F601CC0BA0FCDA468430A91_809810269.addTaint(taint);
            return var671F4D920F601CC0BA0FCDA468430A91_809810269;
}
        } 
        else
        {
switch(tag){
            case DERTags.SET:
            ASN1Exception var27D2F8B75FACA3B971F48C169908899E_2040275123 = new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
            var27D2F8B75FACA3B971F48C169908899E_2040275123.addTaint(taint);
            throw var27D2F8B75FACA3B971F48C169908899E_2040275123;
            case DERTags.SEQUENCE:
            ASN1Exception var543D1EC6A1924AB5C01653E335549EF7_1862855147 = new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
            var543D1EC6A1924AB5C01653E335549EF7_1862855147.addTaint(taint);
            throw var543D1EC6A1924AB5C01653E335549EF7_1862855147;
            case DERTags.OCTET_STRING:
DEREncodable varF1EF7B02C1CEA24C1BADBFEE8E8EE4E1_112052386 =             new DEROctetStringParser((DefiniteLengthInputStream)_in);
            varF1EF7B02C1CEA24C1BADBFEE8E8EE4E1_112052386.addTaint(taint);
            return varF1EF7B02C1CEA24C1BADBFEE8E8EE4E1_112052386;
}
        } 
        RuntimeException var03C1D0D807EF8DD6888BC794B5698198_1754765653 = new RuntimeException("implicit tagging not implemented");
        var03C1D0D807EF8DD6888BC794B5698198_1754765653.addTaint(taint);
        throw var03C1D0D807EF8DD6888BC794B5698198_1754765653;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.722 -0400", hash_original_method = "52179F915187689C742CC095EFF2DB0F", hash_generated_method = "33B2D80033B9AC2AEDFD6744A3CBA7B9")
     DERObject readTaggedObject(boolean constructed, int tag) throws IOException {
        addTaint(tag);
        addTaint(constructed);
    if(!constructed)        
        {
            DefiniteLengthInputStream defIn = (DefiniteLengthInputStream)_in;
DERObject var853BC5EA4168A60BF0F7A8C1E61B802A_2003520147 =             new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
            var853BC5EA4168A60BF0F7A8C1E61B802A_2003520147.addTaint(taint);
            return var853BC5EA4168A60BF0F7A8C1E61B802A_2003520147;
        } 
        ASN1EncodableVector v = readVector();
    if(_in instanceof IndefiniteLengthInputStream)        
        {
DERObject varC07ACA78BFC88AF6278E6A4455DBEB23_1095500811 =             v.size() == 1
                ?   new BERTaggedObject(true, tag, v.get(0))
                :   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
            varC07ACA78BFC88AF6278E6A4455DBEB23_1095500811.addTaint(taint);
            return varC07ACA78BFC88AF6278E6A4455DBEB23_1095500811;
        } 
DERObject var1D06EA7540ADBA3F4001D24F22BE44FD_1482632649 =         v.size() == 1
            ?   new DERTaggedObject(true, tag, v.get(0))
            :   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
        var1D06EA7540ADBA3F4001D24F22BE44FD_1482632649.addTaint(taint);
        return var1D06EA7540ADBA3F4001D24F22BE44FD_1482632649;
        
        
        
            
            
        
        
        
        
            
                
                
        
        
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.724 -0400", hash_original_method = "8294A0F9B070E477A3BFFFBCF1187D7F", hash_generated_method = "A4645CE1E27BD2EF540D1AEA9C486559")
    public DEREncodable readObject() throws IOException {
        int tag = _in.read();
    if(tag == -1)        
        {
DEREncodable var540C13E9E156B687226421B24F2DF178_1806242661 =             null;
            var540C13E9E156B687226421B24F2DF178_1806242661.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1806242661;
        } 
        set00Check(false);
        int tagNo = ASN1InputStream.readTagNumber(_in, tag);
        boolean isConstructed = (tag & DERTags.CONSTRUCTED) != 0;
        int length = ASN1InputStream.readLength(_in, _limit);
    if(length < 0)        
        {
    if(!isConstructed)            
            {
                IOException var0055B29725078D64828DFE2C61240180_1110340341 = new IOException("indefinite length primitive encoding encountered");
                var0055B29725078D64828DFE2C61240180_1110340341.addTaint(taint);
                throw var0055B29725078D64828DFE2C61240180_1110340341;
            } 
            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(_in, _limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, _limit);
    if((tag & DERTags.APPLICATION) != 0)            
            {
DEREncodable var11ED764D242250CD7F8796812C709662_1457111447 =                 new BERApplicationSpecificParser(tagNo, sp);
                var11ED764D242250CD7F8796812C709662_1457111447.addTaint(taint);
                return var11ED764D242250CD7F8796812C709662_1457111447;
            } 
    if((tag & DERTags.TAGGED) != 0)            
            {
DEREncodable varC2894F79D4C623555CCB74DE12AE955C_1198439809 =                 new BERTaggedObjectParser(true, tagNo, sp);
                varC2894F79D4C623555CCB74DE12AE955C_1198439809.addTaint(taint);
                return varC2894F79D4C623555CCB74DE12AE955C_1198439809;
            } 
DEREncodable var46F2CE50264694A30A6F430C496E99D2_2024813572 =             sp.readIndef(tagNo);
            var46F2CE50264694A30A6F430C496E99D2_2024813572.addTaint(taint);
            return var46F2CE50264694A30A6F430C496E99D2_2024813572;
        } 
        else
        {
            DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(_in, length);
    if((tag & DERTags.APPLICATION) != 0)            
            {
DEREncodable varE34C51A9354A8B1A118F6CDDBBAC7679_329353926 =                 new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
                varE34C51A9354A8B1A118F6CDDBBAC7679_329353926.addTaint(taint);
                return varE34C51A9354A8B1A118F6CDDBBAC7679_329353926;
            } 
    if((tag & DERTags.TAGGED) != 0)            
            {
DEREncodable var3F7CFA2B5670FDD716D37A008015C64C_1559249222 =                 new BERTaggedObjectParser(isConstructed, tagNo, new ASN1StreamParser(defIn));
                var3F7CFA2B5670FDD716D37A008015C64C_1559249222.addTaint(taint);
                return var3F7CFA2B5670FDD716D37A008015C64C_1559249222;
            } 
    if(isConstructed)            
            {
switch(tagNo){
                case DERTags.OCTET_STRING:
DEREncodable var293467A9B5E183F19734AAA557191C58_1595934734 =                 new BEROctetStringParser(new ASN1StreamParser(defIn));
                var293467A9B5E183F19734AAA557191C58_1595934734.addTaint(taint);
                return var293467A9B5E183F19734AAA557191C58_1595934734;
                case DERTags.SEQUENCE:
DEREncodable varDE608D6EEF3B29360518C0EEDD47BD39_58021440 =                 new DERSequenceParser(new ASN1StreamParser(defIn));
                varDE608D6EEF3B29360518C0EEDD47BD39_58021440.addTaint(taint);
                return varDE608D6EEF3B29360518C0EEDD47BD39_58021440;
                case DERTags.SET:
DEREncodable var6F2B2C00A12131343DF8ED21FD471FF1_1103954941 =                 new DERSetParser(new ASN1StreamParser(defIn));
                var6F2B2C00A12131343DF8ED21FD471FF1_1103954941.addTaint(taint);
                return var6F2B2C00A12131343DF8ED21FD471FF1_1103954941;
                case DERTags.EXTERNAL:
DEREncodable var489DFE957303AABCED158DB4BFEC92B9_1402356235 =                 new DERExternalParser(new ASN1StreamParser(defIn));
                var489DFE957303AABCED158DB4BFEC92B9_1402356235.addTaint(taint);
                return var489DFE957303AABCED158DB4BFEC92B9_1402356235;
                default:
DEREncodable varD10C2E8D563A110A48696C7D62447036_787668969 =                 new DERUnknownTag(true, tagNo, defIn.toByteArray());
                varD10C2E8D563A110A48696C7D62447036_787668969.addTaint(taint);
                return varD10C2E8D563A110A48696C7D62447036_787668969;
}
            } 
switch(tagNo){
            case DERTags.OCTET_STRING:
DEREncodable var6987EF6B6D8E5EBDFB82EBF5A7D03817_501686295 =             new DEROctetStringParser(defIn);
            var6987EF6B6D8E5EBDFB82EBF5A7D03817_501686295.addTaint(taint);
            return var6987EF6B6D8E5EBDFB82EBF5A7D03817_501686295;
}            try 
            {
DEREncodable var645D42AEC1170006BF2760866022159D_169530297 =                 ASN1InputStream.createPrimitiveDERObject(tagNo, defIn.toByteArray());
                var645D42AEC1170006BF2760866022159D_169530297.addTaint(taint);
                return var645D42AEC1170006BF2760866022159D_169530297;
            } 
            catch (IllegalArgumentException e)
            {
                ASN1Exception var30FC1394D6DD5B9F39A6694742A3F039_1783380818 = new ASN1Exception("corrupted stream detected", e);
                var30FC1394D6DD5B9F39A6694742A3F039_1783380818.addTaint(taint);
                throw var30FC1394D6DD5B9F39A6694742A3F039_1783380818;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.725 -0400", hash_original_method = "4F333A451CCAA8C49D86BC8C0430A606", hash_generated_method = "E70C09FFF2F6AA5D68125DB92827308D")
    private void set00Check(boolean enabled) {
        addTaint(enabled);
    if(_in instanceof IndefiniteLengthInputStream)        
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.725 -0400", hash_original_method = "0431F63F80CE6652BCE08CECE2E42AA0", hash_generated_method = "0E7806AE68CA0BDD0C111779EB41942F")
     ASN1EncodableVector readVector() throws IOException {
        ASN1EncodableVector v = new ASN1EncodableVector();
        DEREncodable obj;
        while
((obj = readObject()) != null)        
        {
    if(obj instanceof InMemoryRepresentable)            
            {
                v.add(((InMemoryRepresentable)obj).getLoadedObject());
            } 
            else
            {
                v.add(obj.getDERObject());
            } 
        } 
ASN1EncodableVector var6DC76BC51820DD65E8396280E884AA78_1333959272 =         v;
        var6DC76BC51820DD65E8396280E884AA78_1333959272.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_1333959272;
        
        
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
}

