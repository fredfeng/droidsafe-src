package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Closeable extends AutoCloseable {

    
    void close() throws IOException;
}
