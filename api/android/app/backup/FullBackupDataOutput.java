package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ParcelFileDescriptor;

public class FullBackupDataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.179 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "95CD9513D49C95A59EDDF775AA30563D")

    private BackupDataOutput mData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.179 -0400", hash_original_method = "F20038FDD5E96BD5179FFCE81ABE9BCA", hash_generated_method = "336EF307BBCD1C14672BB6762218FCFC")
    public  FullBackupDataOutput(ParcelFileDescriptor fd) {
        mData = new BackupDataOutput(fd.getFileDescriptor());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.180 -0400", hash_original_method = "F187747EE8138E5AF15EC08135568EB6", hash_generated_method = "BD1CCBB5C2EE9D5ED80F60CC2D55BCCA")
    public BackupDataOutput getData() {
BackupDataOutput var623C3F1D556EBC2E104B1DFEC3C5702A_1761031127 =         mData;
        var623C3F1D556EBC2E104B1DFEC3C5702A_1761031127.addTaint(taint);
        return var623C3F1D556EBC2E104B1DFEC3C5702A_1761031127;
        
        
    }

    
}

