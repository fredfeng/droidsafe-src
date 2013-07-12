package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class FileNotFoundException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.567 -0400", hash_original_method = "5655520ED34EDABAA2AA5E324B421F90", hash_generated_method = "6C54B6B06E8CFF64E97527885C62D6DC")
    public  FileNotFoundException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.568 -0400", hash_original_method = "84F2811DBCCBCE4B9E51EB4FDB1C21D5", hash_generated_method = "76951E823D18CCDEC2FBD41D5844B891")
    public  FileNotFoundException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.569 -0400", hash_original_field = "AC54BD0C063448143C1920321D07DEB9", hash_generated_field = "30AE48B68F3E5FDD84FAAA1767F19D64")

    private static final long serialVersionUID = -897856973823710492L;
}

