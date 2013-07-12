package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface ScatteringByteChannel extends ReadableByteChannel {

    
    public long read(ByteBuffer[] buffers) throws IOException;

    
    public long read(ByteBuffer[] buffers, int offset, int length)
            throws IOException;
}
