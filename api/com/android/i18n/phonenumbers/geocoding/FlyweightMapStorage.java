package com.android.i18n.phonenumbers.geocoding;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

class FlyweightMapStorage extends AreaCodeMapStorageStrategy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.413 -0400", hash_original_field = "0DE9A1D17B5CC9CA8CBC453E6D75DBEC", hash_generated_field = "F76986CA8B87BC245B249A85A8272854")

    private int prefixSizeInBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.413 -0400", hash_original_field = "E5EE5AE424871B3F62BFEA7F66E19ABA", hash_generated_field = "9301311B3EBB2C817FC2602DD9113DFE")

    private int descIndexSizeInBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.413 -0400", hash_original_field = "0478D9B86559137B4E632D5910E2F2C6", hash_generated_field = "FB05A510369364A4962318241B573EEF")

    private ByteBuffer phoneNumberPrefixes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.414 -0400", hash_original_field = "935BB7D7BB6E6B95FAC76E850864958D", hash_generated_field = "8DD3BA710A227D567B0C909055F247B4")

    private ByteBuffer descriptionIndexes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.414 -0400", hash_original_field = "19BE5C311BDF1A1DA4FFFDE2B1DD7781", hash_generated_field = "3FD4D5B3EAEAE753A19E3DEE1164A725")

    private String[] descriptionPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.414 -0400", hash_original_method = "17265440A4150496F4E4B3AED89DBE4A", hash_generated_method = "0B56FFACCBE5FD82AEECA13F4E299B52")
    public  FlyweightMapStorage() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.414 -0400", hash_original_method = "8579179DB51630AA1D46F39490760068", hash_generated_method = "9187FAC644D890FEE51323D5788E32F2")
    @Override
    public boolean isFlyweight() {
        boolean varB326B5062B2F0E69046810717534CB09_311898154 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670146487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_670146487;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static int getOptimalNumberOfBytesForValue(int value) {
        return value <= Short.MAX_VALUE ? SHORT_SIZE : INT_SIZE;
    }

    
        private static void storeWordInBuffer(ByteBuffer buffer, int wordSize, int index, int value) {
        index *= wordSize;
        if (wordSize == SHORT_SIZE) {
      buffer.putShort(index, (short) value);
    } else {
      buffer.putInt(index, value);
    }
    }

    
        private static int readWordFromBuffer(ByteBuffer buffer, int wordSize, int index) {
        index *= wordSize;
        return wordSize == SHORT_SIZE ? buffer.getShort(index) : buffer.getInt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.415 -0400", hash_original_method = "2F4ECD8A243390FA1987AE315BD02BED", hash_generated_method = "AD004F02C9ABE4E53FA930ED5B0BD7F2")
    @Override
    public int getPrefix(int index) {
        addTaint(index);
        int var260D539EF7E4CBA16B9E7D7909112882_1413189993 = (readWordFromBuffer(phoneNumberPrefixes, prefixSizeInBytes, index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176623260 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176623260;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.415 -0400", hash_original_method = "22178ADBDB18A4450F9D0DCE4A5B21CB", hash_generated_method = "B27E85BB83892C6E3B2A7AA810E8F038")
    @Override
    public String getDescription(int index) {
        addTaint(index);
String var241898A6DABBEF51A12E2D4BEDE5883D_741052448 =         descriptionPool[readWordFromBuffer(descriptionIndexes, descIndexSizeInBytes, index)];
        var241898A6DABBEF51A12E2D4BEDE5883D_741052448.addTaint(taint);
        return var241898A6DABBEF51A12E2D4BEDE5883D_741052448;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.418 -0400", hash_original_method = "5E35085461C9905BDA49B756DC2968D6", hash_generated_method = "F510343B2011A3DADC7CD8E9F6990593")
    @Override
    public void readFromSortedMap(SortedMap<Integer, String> sortedAreaCodeMap) {
        SortedSet<String> descriptionsSet = new TreeSet<String>();
        numOfEntries = sortedAreaCodeMap.size();
        prefixSizeInBytes = getOptimalNumberOfBytesForValue(sortedAreaCodeMap.lastKey());
        phoneNumberPrefixes = ByteBuffer.allocate(numOfEntries * prefixSizeInBytes);
        int index = 0;
for(Entry<Integer, String> entry : sortedAreaCodeMap.entrySet())
        {
            int prefix = entry.getKey();
            storeWordInBuffer(phoneNumberPrefixes, prefixSizeInBytes, index++, prefix);
            possibleLengths.add((int) Math.log10(prefix) + 1);
            descriptionsSet.add(entry.getValue());
        } 
        descIndexSizeInBytes = getOptimalNumberOfBytesForValue(descriptionsSet.size() - 1);
        descriptionIndexes = ByteBuffer.allocate(numOfEntries * descIndexSizeInBytes);
        descriptionPool = new String[descriptionsSet.size()];
        descriptionsSet.toArray(descriptionPool);
        index = 0;
for(int i = 0;i < numOfEntries;i++)
        {
            int prefix = readWordFromBuffer(phoneNumberPrefixes, prefixSizeInBytes, i);
            String description = sortedAreaCodeMap.get(prefix);
            int positionInDescriptionPool = Arrays.binarySearch(descriptionPool, description, new Comparator<String>() {
            public int compare(String o1, String o2) { return o1.compareTo(o2); }
          });
            storeWordInBuffer(descriptionIndexes, descIndexSizeInBytes, index++,
                        positionInDescriptionPool);
        } 
        
        
    }

    
        private static void readExternalWord(ObjectInput objectInput, int wordSize,
                                       ByteBuffer outputBuffer, int index) throws IOException {
        index *= wordSize;
        if (wordSize == SHORT_SIZE) {
      outputBuffer.putShort(index, objectInput.readShort());
    } else {
      outputBuffer.putInt(index, objectInput.readInt());
    }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.420 -0400", hash_original_method = "34B883F6EE399DBE00C99A62ABAF8CA0", hash_generated_method = "DC402324F56477FCC77B40049CED3EE9")
    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        prefixSizeInBytes = objectInput.readInt();
        descIndexSizeInBytes = objectInput.readInt();
        int sizeOfLengths = objectInput.readInt();
        possibleLengths.clear();
for(int i = 0;i < sizeOfLengths;i++)
        {
            possibleLengths.add(objectInput.readInt());
        } 
        int descriptionPoolSize = objectInput.readInt();
    if(descriptionPool == null || descriptionPool.length < descriptionPoolSize)        
        {
            descriptionPool = new String[descriptionPoolSize];
        } 
for(int i = 0;i < descriptionPoolSize;i++)
        {
            String description = objectInput.readUTF();
            descriptionPool[i] = description;
        } 
        numOfEntries = objectInput.readInt();
    if(phoneNumberPrefixes == null || phoneNumberPrefixes.capacity() < numOfEntries)        
        {
            phoneNumberPrefixes = ByteBuffer.allocate(numOfEntries * prefixSizeInBytes);
        } 
    if(descriptionIndexes == null || descriptionIndexes.capacity() < numOfEntries)        
        {
            descriptionIndexes = ByteBuffer.allocate(numOfEntries * descIndexSizeInBytes);
        } 
for(int i = 0;i < numOfEntries;i++)
        {
            readExternalWord(objectInput, prefixSizeInBytes, phoneNumberPrefixes, i);
            readExternalWord(objectInput, descIndexSizeInBytes, descriptionIndexes, i);
        } 
        
        
    }

    
        private static void writeExternalWord(ObjectOutput objectOutput, int wordSize,
                                        ByteBuffer inputBuffer, int index) throws IOException {
        index *= wordSize;
        if (wordSize == SHORT_SIZE) {
      objectOutput.writeShort(inputBuffer.getShort(index));
    } else {
      objectOutput.writeInt(inputBuffer.getInt(index));
    }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.421 -0400", hash_original_method = "6F391CD50156CF53BBA3CDABE0E437A9", hash_generated_method = "1B502922A88C56D46136972CC9252B4E")
    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        addTaint(objectOutput.getTaint());
        objectOutput.writeInt(prefixSizeInBytes);
        objectOutput.writeInt(descIndexSizeInBytes);
        int sizeOfLengths = possibleLengths.size();
        objectOutput.writeInt(sizeOfLengths);
for(Integer length : possibleLengths)
        {
            objectOutput.writeInt(length);
        } 
        objectOutput.writeInt(descriptionPool.length);
for(String description : descriptionPool)
        {
            objectOutput.writeUTF(description);
        } 
        objectOutput.writeInt(numOfEntries);
for(int i = 0;i < numOfEntries;i++)
        {
            writeExternalWord(objectOutput, prefixSizeInBytes, phoneNumberPrefixes, i);
            writeExternalWord(objectOutput, descIndexSizeInBytes, descriptionIndexes, i);
        } 
        
        
        
        
        
        
      
    
        
        
      
    
        
        
      
      
    
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.421 -0400", hash_original_field = "56D011CE80777337DC240E00724FCA3A", hash_generated_field = "37950681DC02C7D8897292B6699B2A15")

    private static final int SHORT_SIZE = Short.SIZE / 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:15.421 -0400", hash_original_field = "5374F447D3249A069A9B34714D259D87", hash_generated_field = "9B36A8CD72FCA278DBEC63477DFCC506")

    private static final int INT_SIZE = Integer.SIZE / 8;
}

