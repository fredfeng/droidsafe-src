package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class StructLinger {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.944 -0400", hash_original_field = "40A71E47B0D99B119DE0C65A0B48528E", hash_generated_field = "313A34DC743869D82F472BEDE730F98E")

    public int l_onoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.944 -0400", hash_original_field = "689F9F1C457A5CB3BAE385B3499F4D5F", hash_generated_field = "D8BC60732FDD96B0D1DB46A72316816A")

    public int l_linger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.945 -0400", hash_original_method = "B2DBC5125F252FD79E2837DA3A5E5C7A", hash_generated_method = "01C58025B7637D560E391B8C3FEF0630")
    public  StructLinger(int l_onoff, int l_linger) {
        this.l_onoff = l_onoff;
        this.l_linger = l_linger;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.946 -0400", hash_original_method = "9E5D902293FF11591147857F4F3E0D72", hash_generated_method = "23E480106333C75D6F639960054801BF")
    public boolean isOn() {
        boolean var9FCDD5FD809A980019197A7D33BCB739_1013316432 = (l_onoff != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978630324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978630324;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.946 -0400", hash_original_method = "F93BE5BFF4FFDE74302B318FFC6DC0AC", hash_generated_method = "CFC9E4A60770E0AB2F1F015423BD38A2")
    @Override
    public String toString() {
String varA38357D6AA0CF52F3B27B2ABCC04C849_234452536 =         "StructLinger[l_onoff=" + l_onoff + ",l_linger=" + l_linger + "]";
        varA38357D6AA0CF52F3B27B2ABCC04C849_234452536.addTaint(taint);
        return varA38357D6AA0CF52F3B27B2ABCC04C849_234452536;
        
        
    }

    
}

