package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.charset.Charset;

public class UnsafeByteSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.761 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private byte[] bytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.761 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.763 -0400", hash_original_method = "3B8A36370055AF819C3748255F1BDC68", hash_generated_method = "B480D5F65BA5A041317D50ECA353DED2")
    public  UnsafeByteSequence(int initialCapacity) {
        this.bytes = new byte[initialCapacity];
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.764 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "89136E31EE387140FF40573112817989")
    public int size() {
        int varE2942A04780E223B215EB8B663CF5353_578873832 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88947964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88947964;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.767 -0400", hash_original_method = "CD6FA0D10C84692422449C0C5D320E8A", hash_generated_method = "37A38F7B043D44D70AC23E12C0B9583A")
    public void rewind() {
        count = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.770 -0400", hash_original_method = "5B2175FB0361CE80BA769109F54D5CFC", hash_generated_method = "06D3F608A4A3FDA6E771AF9004841FFD")
    public void write(byte[] buffer, int offset, int length) {
        addTaint(offset);
        addTaint(buffer[0]);
    if(count + length >= bytes.length)        
        {
            byte[] newBytes = new byte[(count + length) * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } 
        System.arraycopy(buffer, offset, bytes, count, length);
        count += length;
        
        
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.772 -0400", hash_original_method = "CCB897927F45B316C80C49A08CD4BEC5", hash_generated_method = "1D2502F559198FAEF4B9356225ECC793")
    public void write(int b) {
    if(count == bytes.length)        
        {
            byte[] newBytes = new byte[count * 2];
            System.arraycopy(bytes, 0, newBytes, 0, count);
            bytes = newBytes;
        } 
        bytes[count++] = (byte) b;
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.772 -0400", hash_original_method = "6A961C2A026EF073EA4353A09C4F8B0B", hash_generated_method = "7D5ABCEE4765B71D321978E43376B6CC")
    @FindBugsSuppressWarnings("EI_EXPOSE_REP")
    public byte[] toByteArray() {
    if(count == bytes.length)        
        {
            byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_805576625 = (bytes);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1258088416 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1258088416;
        } 
        byte[] result = new byte[count];
        System.arraycopy(bytes, 0, result, 0, count);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1100506852 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1880712864 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1880712864;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.773 -0400", hash_original_method = "EBA6423CDD36F9469C412144E3270E61", hash_generated_method = "D76EACDC950D2D60CEB94E2BA94242BA")
    public String toString(Charset cs) {
        addTaint(cs.getTaint());
String varA272CD35FAECEC96162B7ABE2A851E23_78833218 =         new String(bytes, 0, count, cs);
        varA272CD35FAECEC96162B7ABE2A851E23_78833218.addTaint(taint);
        return varA272CD35FAECEC96162B7ABE2A851E23_78833218;
        
        
    }

    
}

