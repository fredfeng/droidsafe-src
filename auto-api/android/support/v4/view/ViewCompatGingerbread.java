package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.View;

class ViewCompatGingerbread {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.042 -0400", hash_original_method = "190F874704D971FD8CFC3341F59D2192", hash_generated_method = "190F874704D971FD8CFC3341F59D2192")
    public ViewCompatGingerbread ()
    {
        //Synthesized constructor
    }


    public static int getOverScrollMode(View v) {
        return v.getOverScrollMode();
    }

    
    public static void setOverScrollMode(View v, int mode) {
        v.setOverScrollMode(mode);
    }

    
}

