package android.nfc.tech;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class Ndef extends BasicTagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.975 -0400", hash_original_field = "86DEF057D6C153F9465C3DFD099AF5F7", hash_generated_field = "147ADCC633068E8F332A302E1540AD62")

    private int mMaxNdefSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.975 -0400", hash_original_field = "B5278EC7E3332C34F3E9480E899A5F4E", hash_generated_field = "C0E8A71CC004D481AAC21A06997161CB")

    private int mCardState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.975 -0400", hash_original_field = "BB0E2A602300B19A643B3ECA78FFBDB4", hash_generated_field = "B3FEA61CE75C91D3B77101D5899B2CCA")

    private NdefMessage mNdefMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.975 -0400", hash_original_field = "1831557E43D4B2CB9A9C35FD125E5D44", hash_generated_field = "5C9298B1E249A04AB9B947E9A8D2BBE2")

    private int mNdefType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.976 -0400", hash_original_method = "F00E44EC8DF6B41B74270E57D440DE27", hash_generated_method = "998A02F9DD2CE3F8BC0547A8C62F990F")
    public  Ndef(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF);
        addTaint(tag.getTaint());
        Bundle extras = tag.getTechExtras(TagTechnology.NDEF);
    if(extras != null)        
        {
            mMaxNdefSize = extras.getInt(EXTRA_NDEF_MAXLENGTH);
            mCardState = extras.getInt(EXTRA_NDEF_CARDSTATE);
            mNdefMsg = extras.getParcelable(EXTRA_NDEF_MSG);
            mNdefType = extras.getInt(EXTRA_NDEF_TYPE);
        } 
        else
        {
            NullPointerException var73A7D11C3D4A751D875ACA3C3BD4F0F7_264780696 = new NullPointerException("NDEF tech extras are null.");
            var73A7D11C3D4A751D875ACA3C3BD4F0F7_264780696.addTaint(taint);
            throw var73A7D11C3D4A751D875ACA3C3BD4F0F7_264780696;
        } 
        
        
        
            
            
            
            
        
            
        
    }

    
        public static Ndef get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF)) return null;
        try {
            return new Ndef(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.977 -0400", hash_original_method = "522E1BD05C0F58597909DF2D37B1E51E", hash_generated_method = "399F10DAB861BA0EAA69165285BF24AE")
    public NdefMessage getCachedNdefMessage() {
NdefMessage var50637A8CAA6C154F069E6CB5B77579E1_338314332 =         mNdefMsg;
        var50637A8CAA6C154F069E6CB5B77579E1_338314332.addTaint(taint);
        return var50637A8CAA6C154F069E6CB5B77579E1_338314332;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.977 -0400", hash_original_method = "A8A4A8CA63E3E206537FB1A4A1A58DE6", hash_generated_method = "10204BDF40E4ECD7D8B8642ECB041EA1")
    public String getType() {
switch(mNdefType){
        case TYPE_1:
String var794CE4CEDD2907590E2103C6E3657DBF_1319520640 =         NFC_FORUM_TYPE_1;
        var794CE4CEDD2907590E2103C6E3657DBF_1319520640.addTaint(taint);
        return var794CE4CEDD2907590E2103C6E3657DBF_1319520640;
        case TYPE_2:
String varB2F93909976590B91D2FBC568DB5569B_791434828 =         NFC_FORUM_TYPE_2;
        varB2F93909976590B91D2FBC568DB5569B_791434828.addTaint(taint);
        return varB2F93909976590B91D2FBC568DB5569B_791434828;
        case TYPE_3:
String varBE2BAF271F92343335963AA45B3B7AE3_1482375523 =         NFC_FORUM_TYPE_3;
        varBE2BAF271F92343335963AA45B3B7AE3_1482375523.addTaint(taint);
        return varBE2BAF271F92343335963AA45B3B7AE3_1482375523;
        case TYPE_4:
String var15A7665729B8038AB72C7314B4B47D60_794796818 =         NFC_FORUM_TYPE_4;
        var15A7665729B8038AB72C7314B4B47D60_794796818.addTaint(taint);
        return var15A7665729B8038AB72C7314B4B47D60_794796818;
        case TYPE_MIFARE_CLASSIC:
String varC771AB2F6A74B78CDFADAE2F652F3C5B_2069086465 =         MIFARE_CLASSIC;
        varC771AB2F6A74B78CDFADAE2F652F3C5B_2069086465.addTaint(taint);
        return varC771AB2F6A74B78CDFADAE2F652F3C5B_2069086465;
        case TYPE_ICODE_SLI:
String var9C4F0FC9974A0DB3F66CBAEC40F2C733_421744774 =         ICODE_SLI;
        var9C4F0FC9974A0DB3F66CBAEC40F2C733_421744774.addTaint(taint);
        return var9C4F0FC9974A0DB3F66CBAEC40F2C733_421744774;
        default:
String var49B0340B189DF21DA2EA3B0C615D6956_1816627683 =         UNKNOWN;
        var49B0340B189DF21DA2EA3B0C615D6956_1816627683.addTaint(taint);
        return var49B0340B189DF21DA2EA3B0C615D6956_1816627683;
}
        
        
            
                
            
                
            
                
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.977 -0400", hash_original_method = "4EADEE4A8AA14EA957D69BF1EB117D34", hash_generated_method = "4F634272A829D01691C8A2A70F40F197")
    public int getMaxSize() {
        int var86DEF057D6C153F9465C3DFD099AF5F7_1683567870 = (mMaxNdefSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217286854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217286854;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.978 -0400", hash_original_method = "9C15355B29C0704385FAC8BA222CAFE7", hash_generated_method = "43EF999DCA08CB0F0CCBFDB8DDBBDB52")
    public boolean isWritable() {
        boolean varA0046E7AEC22D68949B4767022B18C54_2031903712 = ((mCardState == NDEF_MODE_READ_WRITE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730721510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_730721510;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.978 -0400", hash_original_method = "A26F5401571035886FCD1ABC90F65CF6", hash_generated_method = "1089E2D778C3A4C8A28B37C276422A8F")
    public NdefMessage getNdefMessage() throws IOException, FormatException {
        checkConnected();
        try 
        {
            INfcTag tagService = mTag.getTagService();
            int serviceHandle = mTag.getServiceHandle();
    if(tagService.isNdef(serviceHandle))            
            {
                NdefMessage msg = tagService.ndefRead(serviceHandle);
    if(msg == null)                
                {
                    int errorCode = tagService.getLastError(serviceHandle);
switch(errorCode){
                    case ErrorCodes.ERROR_IO:
                    IOException var1508E3FDF27FD56D4E1051DB16DE1816_204488186 = new IOException();
                    var1508E3FDF27FD56D4E1051DB16DE1816_204488186.addTaint(taint);
                    throw var1508E3FDF27FD56D4E1051DB16DE1816_204488186;
                    case ErrorCodes.ERROR_INVALID_PARAM:
                    FormatException var5AE822463340EC06A6F1D312B3631805_1912351122 = new FormatException();
                    var5AE822463340EC06A6F1D312B3631805_1912351122.addTaint(taint);
                    throw var5AE822463340EC06A6F1D312B3631805_1912351122;
                    default:
                    IOException var1508E3FDF27FD56D4E1051DB16DE1816_2121804544 = new IOException();
                    var1508E3FDF27FD56D4E1051DB16DE1816_2121804544.addTaint(taint);
                    throw var1508E3FDF27FD56D4E1051DB16DE1816_2121804544;
}
                } 
NdefMessage varEDC5B72465A7F0BEE288689BCB1DD141_1288265556 =                 msg;
                varEDC5B72465A7F0BEE288689BCB1DD141_1288265556.addTaint(taint);
                return varEDC5B72465A7F0BEE288689BCB1DD141_1288265556;
            } 
            else
            {
NdefMessage var540C13E9E156B687226421B24F2DF178_1305101126 =                 null;
                var540C13E9E156B687226421B24F2DF178_1305101126.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1305101126;
            } 
        } 
        catch (RemoteException e)
        {
NdefMessage var540C13E9E156B687226421B24F2DF178_1436782481 =             null;
            var540C13E9E156B687226421B24F2DF178_1436782481.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1436782481;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.979 -0400", hash_original_method = "A66DE5F0B266681092CD198588C2EDA0", hash_generated_method = "55C6F5E03FDB4AFC90263DA03261660F")
    public void writeNdefMessage(NdefMessage msg) throws IOException, FormatException {
        addTaint(msg.getTaint());
        checkConnected();
        try 
        {
            INfcTag tagService = mTag.getTagService();
            int serviceHandle = mTag.getServiceHandle();
    if(tagService.isNdef(serviceHandle))            
            {
                int errorCode = tagService.ndefWrite(serviceHandle, msg);
switch(errorCode){
                case ErrorCodes.SUCCESS:
                break;
                case ErrorCodes.ERROR_IO:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1566197873 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1566197873.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1566197873;
                case ErrorCodes.ERROR_INVALID_PARAM:
                FormatException var5AE822463340EC06A6F1D312B3631805_705870409 = new FormatException();
                var5AE822463340EC06A6F1D312B3631805_705870409.addTaint(taint);
                throw var5AE822463340EC06A6F1D312B3631805_705870409;
                default:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_18182765 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_18182765.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_18182765;
}
            } 
            else
            {
                IOException var3B3079A43865D115F17252AB7ABEB56D_1773553994 = new IOException("Tag is not ndef");
                var3B3079A43865D115F17252AB7ABEB56D_1773553994.addTaint(taint);
                throw var3B3079A43865D115F17252AB7ABEB56D_1773553994;
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.980 -0400", hash_original_method = "7292FD9562AEE851073EE82DFE58EB20", hash_generated_method = "521B16435B4CA500D824F5752493F3DD")
    public boolean canMakeReadOnly() {
        INfcTag tagService = mTag.getTagService();
        try 
        {
            boolean var0CFB1C74CC366EEA4AD8A9AEB49DD113_109157594 = (tagService.canMakeReadOnly(mNdefType));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098893292 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098893292;
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_267700404 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141611067 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_141611067;
        } 
        
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.988 -0400", hash_original_method = "4D610B9041279D39FD5203194F60B421", hash_generated_method = "AEC121CDECD91848C04A951321EB0ADD")
    public boolean makeReadOnly() throws IOException {
        checkConnected();
        try 
        {
            INfcTag tagService = mTag.getTagService();
    if(tagService.isNdef(mTag.getServiceHandle()))            
            {
                int errorCode = tagService.ndefMakeReadOnly(mTag.getServiceHandle());
switch(errorCode){
                case ErrorCodes.SUCCESS:
                boolean varB326B5062B2F0E69046810717534CB09_651490174 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046468076 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046468076;
                case ErrorCodes.ERROR_IO:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_793618616 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_793618616.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_793618616;
                case ErrorCodes.ERROR_INVALID_PARAM:
                boolean var68934A3E9455FA72420237EB05902327_1308502198 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711472119 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711472119;
                default:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1787141784 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1787141784.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1787141784;
}
            } 
            else
            {
                IOException var3B3079A43865D115F17252AB7ABEB56D_763345968 = new IOException("Tag is not ndef");
                var3B3079A43865D115F17252AB7ABEB56D_763345968.addTaint(taint);
                throw var3B3079A43865D115F17252AB7ABEB56D_763345968;
            } 
        } 
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1172547998 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329982902 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329982902;
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "A2AB745B5F82024F458B901908B3AD29", hash_generated_field = "5DBF9CCE6E13B976C8A1637F644EF8AF")

    public static final int NDEF_MODE_READ_ONLY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "CA9A1EADBFD22C8FAE378F77A7CB2989", hash_generated_field = "9AF473C2877E6CEDA9FDC11F4F5C6B13")

    public static final int NDEF_MODE_READ_WRITE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "6C6D6C827464E7E412E528EAE110B2F2", hash_generated_field = "5D6A58E2CFE31E870DD9ECCB6CB28BCF")

    public static final int NDEF_MODE_UNKNOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "A80C5A2169A823A76B5297F5B7A3A355", hash_generated_field = "03D3BAE1BAECD74B0536623170B60435")

    public static final String EXTRA_NDEF_MSG = "ndefmsg";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "C1C8E08A49E499FB0F9157AAB747D827", hash_generated_field = "E9849B00182607135A66EA385BB6EEDF")

    public static final String EXTRA_NDEF_MAXLENGTH = "ndefmaxlength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "5D4D94FD01B74D1E9CDF93DD8A7C687D", hash_generated_field = "E60DC935E7366BEE7CB8A6BCC1E76C3F")

    public static final String EXTRA_NDEF_CARDSTATE = "ndefcardstate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "620DE4DC73F430C98FD76B469B906C93", hash_generated_field = "3A731748AEA21BE10691299B82543FC6")

    public static final String EXTRA_NDEF_TYPE = "ndeftype";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "76B8E577CDF0E4314525263EBE608297", hash_generated_field = "F774A018B9285EC5E477028D8C8B18CA")

    public static final int TYPE_OTHER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "7ED15780FBDABAC9B4D00BFBAB6D8CF5", hash_generated_field = "B90833880EBD1E3B8DB2C377F2218D95")

    public static final int TYPE_1 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "153D4AF99233EC46E1E73381EC15C999", hash_generated_field = "C4A935A2405F790089A3222823FA06C8")

    public static final int TYPE_2 = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "AC1F32ED62BED4E288C26AA357AAACD8", hash_generated_field = "F9DB7252B6E07488AFF6CA7F881E590E")

    public static final int TYPE_3 = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "CCF4F969EA4D5F0D5DC1974FBFC0C183", hash_generated_field = "DC39DE3899327A06A0E797E04D33EFA7")

    public static final int TYPE_4 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.989 -0400", hash_original_field = "9822D19D7570EBC046555B8BB26BA41F", hash_generated_field = "9C9138A0D6504FF2ED079C833E453D03")

    public static final int TYPE_MIFARE_CLASSIC = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "11DF5D2A73843DEBFEF76B7157D177B1", hash_generated_field = "768AA5E4F024C71B498BC3C645A3E062")

    public static final int TYPE_ICODE_SLI = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "008A8C15155D31F7C7D1AE86B1F2FA29", hash_generated_field = "573D864C4DBFA5B4A14D7BB89E1DF434")

    public static final String UNKNOWN = "android.ndef.unknown";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "4758EEF791762C7159E997E8C1E7FD6C", hash_generated_field = "9B9B0F5F8E000574CA0476F14E8B8681")

    public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "2A4999ED5F3A871D53C75BF6A2161EF1", hash_generated_field = "186E8B71C431D1BE39AB10B1D3DC67AE")

    public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "46EAD74D936578FAA3C8368CBFDA6533", hash_generated_field = "6E8100A3CE039AF9F49634A53A4AD1BE")

    public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "2ACB073EDAA925440530D1F892D9F95E", hash_generated_field = "3C7054635E2F21BC87F3876F24A2784B")

    public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "335AA93DFAF0D225EE1D42A3C77E9853", hash_generated_field = "E94250C73C997BF5AFE2384A69E09FFD")

    public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.990 -0400", hash_original_field = "C54ABBC6D6D93C755C3D3F58C45A2C0E", hash_generated_field = "586FB5EAC65F9D040431B061ED147A30")

    public static final String ICODE_SLI = "com.nxp.ndef.icodesli";
}

