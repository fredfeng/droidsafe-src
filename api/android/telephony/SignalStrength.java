package android.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class SignalStrength implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "36364D56AF7648551EABF35067448EA3", hash_generated_field = "DF212ABBD77FA8BBA06AA948D0C786A3")

    private int mGsmSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "4F36803C89FD3F6E2D99093C436FBBF9", hash_generated_field = "62197276EA9E6CE4D0502EE53FF46E07")

    private int mGsmBitErrorRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "5E0B80EB4A28EC07E79031265C7AE746", hash_generated_field = "E86784A230D482159884E423762742A0")

    private int mCdmaDbm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "F8E9877DC52E8EE8F0DF96254A50BF11", hash_generated_field = "6E97F40BFD836F3CE5BD662C51380A2E")

    private int mCdmaEcio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "434CC9E4495710173A2FB3E253E0CF8B", hash_generated_field = "5F77C00D970A012CF8A70A743502955E")

    private int mEvdoDbm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "F1BE692BEEB4983C117785FF72750B0D", hash_generated_field = "9D4FAC062F6677FEF890917A2CC74060")

    private int mEvdoEcio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "C85157EE67DC34A80E3B67796522D23D", hash_generated_field = "A8393F6F3E55D49B155906169F7DF105")

    private int mEvdoSnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "FBE5D9D9DD310250942F33DAB41678F0", hash_generated_field = "2E9C18263B0918B024A476E0A3021D5D")

    private int mLteSignalStrength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.304 -0400", hash_original_field = "C9762CBD0EAA7A95E02E0A893545B09D", hash_generated_field = "F7BF008784D2B5C3302EECB15948BC9E")

    private int mLteRsrp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.305 -0400", hash_original_field = "066CA432B5E7799DBE42C87AE9CACDE1", hash_generated_field = "034A5562CA8669F3C12137B1EB35AA93")

    private int mLteRsrq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.305 -0400", hash_original_field = "52547F4A6247CE9C757092A5223DE2DB", hash_generated_field = "CF3AA4BA421912BC2B971AF50DDB829D")

    private int mLteRssnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.305 -0400", hash_original_field = "2D8DC7FAC1A5AAD6C5B6837B0661D2F4", hash_generated_field = "39529D74D8B59671DDC05D399EF4A2BD")

    private int mLteCqi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.305 -0400", hash_original_field = "63820013ACAF4CF17E3413B6B4EA67DD", hash_generated_field = "5BB65659E30CE1CC8D95D33184A43135")

    private boolean isGsm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.307 -0400", hash_original_method = "39BD55AB1A011261FC242AC9054B9C2E", hash_generated_method = "D875ED6565624795B17AC9E777BF75B0")
    public  SignalStrength() {
        mGsmSignalStrength = 99;
        mGsmBitErrorRate = -1;
        mCdmaDbm = -1;
        mCdmaEcio = -1;
        mEvdoDbm = -1;
        mEvdoEcio = -1;
        mEvdoSnr = -1;
        mLteSignalStrength = -1;
        mLteRsrp = -1;
        mLteRsrq = -1;
        mLteRssnr = -1;
        mLteCqi = -1;
        isGsm = true;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.310 -0400", hash_original_method = "A4D70EF20E0500A170A5E059B2CA4163", hash_generated_method = "8B3499FE5FE1F52A2BA85D36FF45861A")
    public  SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            int lteSignalStrength, int lteRsrp, int lteRsrq, int lteRssnr, int lteCqi,
            boolean gsm) {
        mGsmSignalStrength = gsmSignalStrength;
        mGsmBitErrorRate = gsmBitErrorRate;
        mCdmaDbm = cdmaDbm;
        mCdmaEcio = cdmaEcio;
        mEvdoDbm = evdoDbm;
        mEvdoEcio = evdoEcio;
        mEvdoSnr = evdoSnr;
        mLteSignalStrength = lteSignalStrength;
        mLteRsrp = lteRsrp;
        mLteRsrq = lteRsrq;
        mLteRssnr = lteRssnr;
        mLteCqi = lteCqi;
        isGsm = gsm;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.312 -0400", hash_original_method = "50D26D8F6F19A1F72234E376840BB613", hash_generated_method = "B75B55533EC54529861535BB55D7AF99")
    public  SignalStrength(int gsmSignalStrength, int gsmBitErrorRate,
            int cdmaDbm, int cdmaEcio,
            int evdoDbm, int evdoEcio, int evdoSnr,
            boolean gsm) {
        this(gsmSignalStrength, gsmBitErrorRate, cdmaDbm, cdmaEcio,
                evdoDbm, evdoEcio, evdoSnr, -1, -1, -1, -1, -1, gsm);
        addTaint(gsm);
        addTaint(evdoSnr);
        addTaint(evdoEcio);
        addTaint(evdoDbm);
        addTaint(cdmaEcio);
        addTaint(cdmaDbm);
        addTaint(gsmBitErrorRate);
        addTaint(gsmSignalStrength);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.312 -0400", hash_original_method = "304799902D63DF1F3D1583B2575C70EA", hash_generated_method = "8775670C6B925846E405B998852B6AAB")
    public  SignalStrength(SignalStrength s) {
        addTaint(s.getTaint());
        copyFrom(s);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.314 -0400", hash_original_method = "2E336C5190A64F570C9C97735BEE0094", hash_generated_method = "FAA7B76356B0BAA9AA3D8202B8B90A6A")
    public  SignalStrength(Parcel in) {
        mGsmSignalStrength = in.readInt();
        mGsmBitErrorRate = in.readInt();
        mCdmaDbm = in.readInt();
        mCdmaEcio = in.readInt();
        mEvdoDbm = in.readInt();
        mEvdoEcio = in.readInt();
        mEvdoSnr = in.readInt();
        mLteSignalStrength = in.readInt();
        mLteRsrp = in.readInt();
        mLteRsrq = in.readInt();
        mLteRssnr = in.readInt();
        mLteCqi = in.readInt();
        isGsm = (in.readInt() != 0);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
        public static SignalStrength newFromBundle(Bundle m) {
        SignalStrength ret;
        ret = new SignalStrength();
        ret.setFromNotifierBundle(m);
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.316 -0400", hash_original_method = "2805E95BBC437ECAE5861EC35986FF86", hash_generated_method = "A7E9AAE67CFBB3173109CFF2547D84E6")
    protected void copyFrom(SignalStrength s) {
        mGsmSignalStrength = s.mGsmSignalStrength;
        mGsmBitErrorRate = s.mGsmBitErrorRate;
        mCdmaDbm = s.mCdmaDbm;
        mCdmaEcio = s.mCdmaEcio;
        mEvdoDbm = s.mEvdoDbm;
        mEvdoEcio = s.mEvdoEcio;
        mEvdoSnr = s.mEvdoSnr;
        mLteSignalStrength = s.mLteSignalStrength;
        mLteRsrp = s.mLteRsrp;
        mLteRsrq = s.mLteRsrq;
        mLteRssnr = s.mLteRssnr;
        mLteCqi = s.mLteCqi;
        isGsm = s.isGsm;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.319 -0400", hash_original_method = "85E260BC5044CD4D9894DB51C4B27CA0", hash_generated_method = "B90DF558AEC913DC18D8555F274B17F0")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeInt(mGsmSignalStrength);
        out.writeInt(mGsmBitErrorRate);
        out.writeInt(mCdmaDbm);
        out.writeInt(mCdmaEcio);
        out.writeInt(mEvdoDbm);
        out.writeInt(mEvdoEcio);
        out.writeInt(mEvdoSnr);
        out.writeInt(mLteSignalStrength);
        out.writeInt(mLteRsrp);
        out.writeInt(mLteRsrq);
        out.writeInt(mLteRssnr);
        out.writeInt(mLteCqi);
        out.writeInt(isGsm ? 1 : 0);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.320 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BF924AAFC3F8109C55A171F2E636BB53")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_90627874 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187519427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187519427;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.320 -0400", hash_original_method = "BF744C5FBE02CF825B56C3345AF59498", hash_generated_method = "CAD8E472A47AFE9CCB4E1F8A58A7DFB6")
    public int getGsmSignalStrength() {
        int varF6D024FCBC092F8CA655B3ADD44E65F2_876911018 = (this.mGsmSignalStrength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434619393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434619393;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.321 -0400", hash_original_method = "092AE71FB082AB370F835236471B5652", hash_generated_method = "36A319C2BB4E062B814CCB92AE4F5813")
    public int getGsmBitErrorRate() {
        int var3D6B6FCA5C55C54B4E9616E3F18CCF4A_2143990266 = (this.mGsmBitErrorRate);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724183135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724183135;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.321 -0400", hash_original_method = "4A3A20AF02DE258CADBBD180CAF3D12D", hash_generated_method = "3FC102228F808571BFD83473523638C6")
    public int getCdmaDbm() {
        int var1634A1D6AA6A3D50C93AE184F8CBD9B3_1990822307 = (this.mCdmaDbm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931873470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931873470;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.321 -0400", hash_original_method = "38AEFFB984E37DCE606B9F88ABDA8DE8", hash_generated_method = "28E0C622A04007DECB12CFCFBB93B79A")
    public int getCdmaEcio() {
        int var26C8A0B22A123734990D48F8274C8129_1998724156 = (this.mCdmaEcio);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214819571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214819571;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.322 -0400", hash_original_method = "D895F9B1A344D14CB24D80BCC48EF38D", hash_generated_method = "BF15ADA9791653BB614C0A112A05A20D")
    public int getEvdoDbm() {
        int varE161CACFF03699C64B2E7386CC1AB736_395654295 = (this.mEvdoDbm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122645423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122645423;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.322 -0400", hash_original_method = "E512C4871B3839CD9850A80797FFBB27", hash_generated_method = "8F9440DF8525648FB66A4D53D46CA7FB")
    public int getEvdoEcio() {
        int var3E78086B484F051EAB78CE913A8DD796_1294767957 = (this.mEvdoEcio);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529540103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529540103;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.322 -0400", hash_original_method = "76215695BF499679C7BA84176FCF6732", hash_generated_method = "DBB1AB0648A66659E5F775C003D75D7F")
    public int getEvdoSnr() {
        int varE1D4E57EE59C0185BEB84F195185B7B5_1793685907 = (this.mEvdoSnr);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435436388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435436388;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.324 -0400", hash_original_method = "7504E540028056CDE39219F81B4E1E59", hash_generated_method = "0652CE67B69742427E8C7C399FB05C2A")
    public int getLevel() {
        int level;
    if(isGsm)        
        {
    if((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1))            
            {
                level = getGsmLevel();
            } 
            else
            {
                level = getLteLevel();
            } 
        } 
        else
        {
            int cdmaLevel = getCdmaLevel();
            int evdoLevel = getEvdoLevel();
    if(evdoLevel == SIGNAL_STRENGTH_NONE_OR_UNKNOWN)            
            {
                level = getCdmaLevel();
            } 
            else
    if(cdmaLevel == SIGNAL_STRENGTH_NONE_OR_UNKNOWN)            
            {
                level = getEvdoLevel();
            } 
            else
            {
                level = cdmaLevel < evdoLevel ? cdmaLevel : evdoLevel;
            } 
        } 
    if(DBG)        
        log("getLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_457728178 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430151593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430151593;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.326 -0400", hash_original_method = "6887E245B7148208FA71118C76512694", hash_generated_method = "90195C7386433559EC57EFA2BEBF8D36")
    public int getAsuLevel() {
        int asuLevel;
    if(isGsm)        
        {
    if((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1))            
            {
                asuLevel = getGsmAsuLevel();
            } 
            else
            {
                asuLevel = getLteAsuLevel();
            } 
        } 
        else
        {
            int cdmaAsuLevel = getCdmaAsuLevel();
            int evdoAsuLevel = getEvdoAsuLevel();
    if(evdoAsuLevel == 0)            
            {
                asuLevel = cdmaAsuLevel;
            } 
            else
    if(cdmaAsuLevel == 0)            
            {
                asuLevel = evdoAsuLevel;
            } 
            else
            {
                asuLevel = cdmaAsuLevel < evdoAsuLevel ? cdmaAsuLevel : evdoAsuLevel;
            } 
        } 
    if(DBG)        
        log("getAsuLevel=" + asuLevel);
        int var0A23479432B8D79D03BA8EAF294724FF_555184271 = (asuLevel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1777547373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1777547373;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.327 -0400", hash_original_method = "91A92262F8869E8CA480E3922C8E164F", hash_generated_method = "A840A221F32E038E427F1426D951A3D1")
    public int getDbm() {
        int dBm;
    if(isGsm())        
        {
    if((mLteSignalStrength == -1)
                    && (mLteRsrp == -1)
                    && (mLteRsrq == -1)
                    && (mLteRssnr == -1)
                    && (mLteCqi == -1))            
            {
                dBm = getGsmDbm();
            } 
            else
            {
                dBm = getLteDbm();
            } 
        } 
        else
        {
            dBm = getCdmaDbm();
        } 
    if(DBG)        
        log("getDbm=" + dBm);
        int var21B2C5773D09C68FE13DD43912183F9B_1537692584 = (dBm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219116544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219116544;
        
        
        
            
                    
                    
                    
                    
                
            
                
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.328 -0400", hash_original_method = "EDC72A768CC18025065D104AFB382B7A", hash_generated_method = "5DE0B7F2360D20A1DB5AE139071AC768")
    public int getGsmDbm() {
        int dBm;
        int gsmSignalStrength = getGsmSignalStrength();
        int asu = (gsmSignalStrength == 99 ? -1 : gsmSignalStrength);
    if(asu != -1)        
        {
            dBm = -113 + (2 * asu);
        } 
        else
        {
            dBm = -1;
        } 
    if(DBG)        
        log("getGsmDbm=" + dBm);
        int var21B2C5773D09C68FE13DD43912183F9B_1062152749 = (dBm);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630019629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630019629;
        
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.329 -0400", hash_original_method = "B3F3D7206F2B752B03A36760D7E06194", hash_generated_method = "A4F115BB1F89723A395C73ADED766E4A")
    public int getGsmLevel() {
        int level;
        int asu = getGsmSignalStrength();
    if(asu <= 2 || asu == 99)        
        level = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        else
    if(asu >= 12)        
        level = SIGNAL_STRENGTH_GREAT;
        else
    if(asu >= 8)        
        level = SIGNAL_STRENGTH_GOOD;
        else
    if(asu >= 5)        
        level = SIGNAL_STRENGTH_MODERATE;
        else
        level = SIGNAL_STRENGTH_POOR;
    if(DBG)        
        log("getGsmLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_1858987365 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337322067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337322067;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.330 -0400", hash_original_method = "F4862B9CE73023A8FAAD3B95D31594BE", hash_generated_method = "A74877754763BD29B7E4B038D2240E78")
    public int getGsmAsuLevel() {
        int level = getGsmSignalStrength();
    if(DBG)        
        log("getGsmAsuLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_358272432 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690806981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690806981;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.331 -0400", hash_original_method = "CB4649EF15F9DF295DD79289916B6CB5", hash_generated_method = "E91C0C1AA1BA9B7BC0C4E80D6B67294F")
    public int getCdmaLevel() {
        final int cdmaDbm = getCdmaDbm();
        final int cdmaEcio = getCdmaEcio();
        int levelDbm;
        int levelEcio;
    if(cdmaDbm >= -75)        
        levelDbm = SIGNAL_STRENGTH_GREAT;
        else
    if(cdmaDbm >= -85)        
        levelDbm = SIGNAL_STRENGTH_GOOD;
        else
    if(cdmaDbm >= -95)        
        levelDbm = SIGNAL_STRENGTH_MODERATE;
        else
    if(cdmaDbm >= -100)        
        levelDbm = SIGNAL_STRENGTH_POOR;
        else
        levelDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
    if(cdmaEcio >= -90)        
        levelEcio = SIGNAL_STRENGTH_GREAT;
        else
    if(cdmaEcio >= -110)        
        levelEcio = SIGNAL_STRENGTH_GOOD;
        else
    if(cdmaEcio >= -130)        
        levelEcio = SIGNAL_STRENGTH_MODERATE;
        else
    if(cdmaEcio >= -150)        
        levelEcio = SIGNAL_STRENGTH_POOR;
        else
        levelEcio = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        int level = (levelDbm < levelEcio) ? levelDbm : levelEcio;
    if(DBG)        
        log("getCdmaLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_1623430002 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661611712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661611712;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.333 -0400", hash_original_method = "EE526C4AB692E407ACE78BB15D53BCB0", hash_generated_method = "95749D8FFE63F28CAE23680BBB8FC0FA")
    public int getCdmaAsuLevel() {
        final int cdmaDbm = getCdmaDbm();
        final int cdmaEcio = getCdmaEcio();
        int cdmaAsuLevel;
        int ecioAsuLevel;
    if(cdmaDbm >= -75)        
        cdmaAsuLevel = 16;
        else
    if(cdmaDbm >= -82)        
        cdmaAsuLevel = 8;
        else
    if(cdmaDbm >= -90)        
        cdmaAsuLevel = 4;
        else
    if(cdmaDbm >= -95)        
        cdmaAsuLevel = 2;
        else
    if(cdmaDbm >= -100)        
        cdmaAsuLevel = 1;
        else
        cdmaAsuLevel = 99;
    if(cdmaEcio >= -90)        
        ecioAsuLevel = 16;
        else
    if(cdmaEcio >= -100)        
        ecioAsuLevel = 8;
        else
    if(cdmaEcio >= -115)        
        ecioAsuLevel = 4;
        else
    if(cdmaEcio >= -130)        
        ecioAsuLevel = 2;
        else
    if(cdmaEcio >= -150)        
        ecioAsuLevel = 1;
        else
        ecioAsuLevel = 99;
        int level = (cdmaAsuLevel < ecioAsuLevel) ? cdmaAsuLevel : ecioAsuLevel;
    if(DBG)        
        log("getCdmaAsuLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_188417824 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585455296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585455296;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.336 -0400", hash_original_method = "0AB26F5835CA97F0ED2A069B69FE7D82", hash_generated_method = "A7390ECC4BD358DEEE0588C3429E68F0")
    public int getEvdoLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;
    if(evdoDbm >= -65)        
        levelEvdoDbm = SIGNAL_STRENGTH_GREAT;
        else
    if(evdoDbm >= -75)        
        levelEvdoDbm = SIGNAL_STRENGTH_GOOD;
        else
    if(evdoDbm >= -90)        
        levelEvdoDbm = SIGNAL_STRENGTH_MODERATE;
        else
    if(evdoDbm >= -105)        
        levelEvdoDbm = SIGNAL_STRENGTH_POOR;
        else
        levelEvdoDbm = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
    if(evdoSnr >= 7)        
        levelEvdoSnr = SIGNAL_STRENGTH_GREAT;
        else
    if(evdoSnr >= 5)        
        levelEvdoSnr = SIGNAL_STRENGTH_GOOD;
        else
    if(evdoSnr >= 3)        
        levelEvdoSnr = SIGNAL_STRENGTH_MODERATE;
        else
    if(evdoSnr >= 1)        
        levelEvdoSnr = SIGNAL_STRENGTH_POOR;
        else
        levelEvdoSnr = SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
        int level = (levelEvdoDbm < levelEvdoSnr) ? levelEvdoDbm : levelEvdoSnr;
    if(DBG)        
        log("getEvdoLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_708182633 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910678449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910678449;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.338 -0400", hash_original_method = "B3D272849081E8A85734C2EAD9030507", hash_generated_method = "A1A8E3169D63738023BEFDDD9ADC194A")
    public int getEvdoAsuLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int levelEvdoDbm;
        int levelEvdoSnr;
    if(evdoDbm >= -65)        
        levelEvdoDbm = 16;
        else
    if(evdoDbm >= -75)        
        levelEvdoDbm = 8;
        else
    if(evdoDbm >= -85)        
        levelEvdoDbm = 4;
        else
    if(evdoDbm >= -95)        
        levelEvdoDbm = 2;
        else
    if(evdoDbm >= -105)        
        levelEvdoDbm = 1;
        else
        levelEvdoDbm = 99;
    if(evdoSnr >= 7)        
        levelEvdoSnr = 16;
        else
    if(evdoSnr >= 6)        
        levelEvdoSnr = 8;
        else
    if(evdoSnr >= 5)        
        levelEvdoSnr = 4;
        else
    if(evdoSnr >= 3)        
        levelEvdoSnr = 2;
        else
    if(evdoSnr >= 1)        
        levelEvdoSnr = 1;
        else
        levelEvdoSnr = 99;
        int level = (levelEvdoDbm < levelEvdoSnr) ? levelEvdoDbm : levelEvdoSnr;
    if(DBG)        
        log("getEvdoAsuLevel=" + level);
        int varC9E9A848920877E76685B2E4E76DE38D_790181769 = (level);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932713407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932713407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.339 -0400", hash_original_method = "94E656AC1ABF6547309F24472B6D486E", hash_generated_method = "8AAA5DCD8306A121FF68AB134F8EBE01")
    public int getLteDbm() {
        int varC9762CBD0EAA7A95E02E0A893545B09D_1600223696 = (mLteRsrp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605213274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605213274;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.340 -0400", hash_original_method = "CDB40306822E2DC8617AD5A6BB9C97E4", hash_generated_method = "25CAE9D9E80A619AC83F8344FC9BD9FF")
    public int getLteLevel() {
        int levelLteRsrp = 0;
    if(mLteRsrp == -1)        
        levelLteRsrp = 0;
        else
    if(mLteRsrp >= -85)        
        levelLteRsrp = SIGNAL_STRENGTH_GREAT;
        else
    if(mLteRsrp >= -95)        
        levelLteRsrp = SIGNAL_STRENGTH_GOOD;
        else
    if(mLteRsrp >= -105)        
        levelLteRsrp = SIGNAL_STRENGTH_MODERATE;
        else
    if(mLteRsrp >= -115)        
        levelLteRsrp = SIGNAL_STRENGTH_POOR;
        else
        levelLteRsrp = 0;
    if(DBG)        
        log("Lte level: "+levelLteRsrp);
        int varA51AFA071C3DD6BE51B5B624324DC6BC_786735671 = (levelLteRsrp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558458745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558458745;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.341 -0400", hash_original_method = "8F8EC9A4414474C4302B52EA8F689AB4", hash_generated_method = "6F8D1EBDF446D372E5518F852BE86E8C")
    public int getLteAsuLevel() {
        int lteAsuLevel = 99;
        int lteDbm = getLteDbm();
    if(lteDbm <= -140)        
        lteAsuLevel = 0;
        else
    if(lteDbm >= -43)        
        lteAsuLevel = 97;
        else
        lteAsuLevel = lteDbm + 140;
    if(DBG)        
        log("Lte Asu level: "+lteAsuLevel);
        int varBC17D11A841959FC6E06C0270787B1E9_1578319496 = (lteAsuLevel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87801694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87801694;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.342 -0400", hash_original_method = "7CBC52492CE7EC66B1A8811456B7D40A", hash_generated_method = "1DA1C507301F60D31D2553FBC50FF1C7")
    public boolean isGsm() {
        boolean var26B70D966913FAE5824B1B6647F5C9F3_550341086 = (this.isGsm);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282847325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_282847325;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.343 -0400", hash_original_method = "77932B1FC1CD240B3EE054141A5B543F", hash_generated_method = "CB1D066EC29351B5386E541785F848CA")
    @Override
    public int hashCode() {
        int primeNum = 31;
        int var461905A7DCCF46114DFA53BFFBA3663C_2045395179 = (((mGsmSignalStrength * primeNum)
                + (mGsmBitErrorRate * primeNum)
                + (mCdmaDbm * primeNum) + (mCdmaEcio * primeNum)
                + (mEvdoDbm * primeNum) + (mEvdoEcio * primeNum) + (mEvdoSnr * primeNum)
                + (mLteSignalStrength * primeNum) + (mLteRsrp * primeNum)
                + (mLteRsrq * primeNum) + (mLteRssnr * primeNum) + (mLteCqi * primeNum)
                + (isGsm ? 1 : 0)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833573435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833573435;
        
        
        
                
                
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.345 -0400", hash_original_method = "42740862A2861DE7D9325894DE272263", hash_generated_method = "585A511ACF01D7D60DE4D5A996F7AB2F")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        SignalStrength s;
        try 
        {
            s = (SignalStrength) o;
        } 
        catch (ClassCastException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_248617295 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213520689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_213520689;
        } 
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_101198824 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162594106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_162594106;
        } 
        boolean varD3F5E11D698AE21F5FA0E987030704AB_1995376127 = ((mGsmSignalStrength == s.mGsmSignalStrength
                && mGsmBitErrorRate == s.mGsmBitErrorRate
                && mCdmaDbm == s.mCdmaDbm
                && mCdmaEcio == s.mCdmaEcio
                && mEvdoDbm == s.mEvdoDbm
                && mEvdoEcio == s.mEvdoEcio
                && mEvdoSnr == s.mEvdoSnr
                && mLteSignalStrength == s.mLteSignalStrength
                && mLteRsrp == s.mLteRsrp
                && mLteRsrq == s.mLteRsrq
                && mLteRssnr == s.mLteRssnr
                && mLteCqi == s.mLteCqi
                && isGsm == s.isGsm));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304212767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_304212767;
        
        
        
            
        
            
        
        
            
        
        
                
                
                
                
                
                
                
                
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.346 -0400", hash_original_method = "4C867D664E694B283CE0DE88ADFC0BF6", hash_generated_method = "80F5805FD6F705D76B764EF12C08AFD2")
    @Override
    public String toString() {
String var3AB1774E337C2A164F26B8C12AE948E0_280544248 =         ("SignalStrength:"
                + " " + mGsmSignalStrength
                + " " + mGsmBitErrorRate
                + " " + mCdmaDbm
                + " " + mCdmaEcio
                + " " + mEvdoDbm
                + " " + mEvdoEcio
                + " " + mEvdoSnr
                + " " + mLteSignalStrength
                + " " + mLteRsrp
                + " " + mLteRsrq
                + " " + mLteRssnr
                + " " + mLteCqi
                + " " + (isGsm ? "gsm|lte" : "cdma"));
        var3AB1774E337C2A164F26B8C12AE948E0_280544248.addTaint(taint);
        return var3AB1774E337C2A164F26B8C12AE948E0_280544248;
        
        
                
                
                
                
                
                
                
                
                
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.349 -0400", hash_original_method = "3660E1E14B95E0E07C3D11C71AA6DC38", hash_generated_method = "57872D825CCE8069EA73912FC049646A")
    private void setFromNotifierBundle(Bundle m) {
        mGsmSignalStrength = m.getInt("GsmSignalStrength");
        mGsmBitErrorRate = m.getInt("GsmBitErrorRate");
        mCdmaDbm = m.getInt("CdmaDbm");
        mCdmaEcio = m.getInt("CdmaEcio");
        mEvdoDbm = m.getInt("EvdoDbm");
        mEvdoEcio = m.getInt("EvdoEcio");
        mEvdoSnr = m.getInt("EvdoSnr");
        mLteSignalStrength = m.getInt("LteSignalStrength");
        mLteRsrp = m.getInt("LteRsrp");
        mLteRsrq = m.getInt("LteRsrq");
        mLteRssnr = m.getInt("LteRssnr");
        mLteCqi = m.getInt("LteCqi");
        isGsm = m.getBoolean("isGsm");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_method = "936283CC8EFD34F7D7362628995C0399", hash_generated_method = "F6A68F433F790947D25FFFAFAAF8E71F")
    public void fillInNotifierBundle(Bundle m) {
        addTaint(m.getTaint());
        m.putInt("GsmSignalStrength", mGsmSignalStrength);
        m.putInt("GsmBitErrorRate", mGsmBitErrorRate);
        m.putInt("CdmaDbm", mCdmaDbm);
        m.putInt("CdmaEcio", mCdmaEcio);
        m.putInt("EvdoDbm", mEvdoDbm);
        m.putInt("EvdoEcio", mEvdoEcio);
        m.putInt("EvdoSnr", mEvdoSnr);
        m.putInt("LteSignalStrength", mLteSignalStrength);
        m.putInt("LteRsrp", mLteRsrp);
        m.putInt("LteRsrq", mLteRsrq);
        m.putInt("LteRssnr", mLteRssnr);
        m.putInt("LteCqi", mLteCqi);
        m.putBoolean("isGsm", Boolean.valueOf(isGsm));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
        private static void log(String s) {
        Log.w(LOG_TAG, s);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_field = "C81CEEA616DACC3409F74A8F2E89C2D7", hash_generated_field = "6E97287BC5323EE3BC717AB66CCBDA0F")

    private static final String LOG_TAG = "SignalStrength";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_field = "E3D80F247EF1D5B34B0E769FD1239224", hash_generated_field = "F36B5DA862F2210B7CC8B63BBEC96BC6")

    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_field = "B7A02C6B4B4F42B51CC6EDA55F844223", hash_generated_field = "97056B85052FD1665F55A477FCCE88E5")

    public static final int SIGNAL_STRENGTH_POOR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_field = "6B215F20C22540EE4A2E519DB5D5D414", hash_generated_field = "3C5058BFCEEB115196EE2231DF9981BF")

    public static final int SIGNAL_STRENGTH_MODERATE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.350 -0400", hash_original_field = "0F3C746ABE8B77807F6D1A46EA2C6AFD", hash_generated_field = "84ECBAA9293AB4A1FA6C266A70AD82B1")

    public static final int SIGNAL_STRENGTH_GOOD = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.351 -0400", hash_original_field = "9446F7559D8E241F4FFD1BC1796DEF80", hash_generated_field = "8354359F6FF7CC86EEAB975D01842E00")

    public static final int SIGNAL_STRENGTH_GREAT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.351 -0400", hash_original_field = "094A086A62C5D628F015BC285BF0F69C", hash_generated_field = "77B4BF83352A596F63869F754229CB9B")

    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.351 -0400", hash_original_field = "E377057C1EA6E7FC917C9D253FD3DA64", hash_generated_field = "BDFDB8B094372B725FE43741B8D7FCCB")

    public static final String[] SIGNAL_STRENGTH_NAMES = {
        "none", "poor", "moderate", "good", "great"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.351 -0400", hash_original_field = "17161E0D5F664640DD3B27CBEFA72BA0", hash_generated_field = "9C95D36DB334C11AD4000563454AA3FC")

    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() {
        public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }

        public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    };
    
    public SignalStrength createFromParcel(Parcel in) {
            return new SignalStrength(in);
        }
    
    
    public SignalStrength[] newArray(int size) {
            return new SignalStrength[size];
        }
    
}

