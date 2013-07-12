package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import javax.net.ssl.SSLHandshakeException;

public class HandshakeIODataStream extends SSLInputStream implements org.apache.harmony.xnet.provider.jsse.Appendable, DataStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.414 -0400", hash_original_field = "C912DD9B833D125CB4248BE9D582C46D", hash_generated_field = "6ABB97B7E5704DAE089E4AEB36CEB9EE")

    private int buff_size = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.414 -0400", hash_original_field = "7E9E292FBE4FFD0168C2F5F9F1DB2FC0", hash_generated_field = "ECE066EAF80B851FA09366F66474CB4F")

    private int inc_buff_size = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_field = "940CE39600E5E7080CFEAD2403914895", hash_generated_field = "59FE230D060C5F66646B4FE7F4893504")

    private byte[] buffer = new byte[buff_size];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_field = "B92B5E19F83F631BC914FCA5A884D74B", hash_generated_field = "EA9B3A76326F890C67C38EEB6FEB8AF9")

    private int read_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_field = "FF4C9C4B982DED2F74B68139F427F08D", hash_generated_field = "27AC92782C57CF0B819B2420AE5376F7")

    private int marked_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_field = "20D41F889DBECBC396FA4C40FD2E9FD7", hash_generated_field = "FF0EA6FB8503DBFADF3AE0199C37EA3B")

    private int read_pos_end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_field = "2F3A60B180AD3CB3DB40437E6D5B8577", hash_generated_field = "2A42DC8A8123A01E2D1E9FEB5459A439")

    private int write_pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_field = "4128F67544D6312811E1F8C637C8EA26", hash_generated_field = "AD1DFD6760C62CD5DA5F016A95D625DE")

    private int write_pos_beg;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.415 -0400", hash_original_method = "C3B776612EB17DF4F4BD48A7062A61E9", hash_generated_method = "0B674141A27031106468BE1CF6DD8582")
    public  HandshakeIODataStream() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.416 -0400", hash_original_method = "BF4923D33B65FF9EACCA5F4B8319A955", hash_generated_method = "5E59256E0BAB21BA166527797D986CDD")
    @Override
    public int available() {
        int varA36AAC7BFD2F648D2B18EC61BBDBFF9E_865278368 = (read_pos_end - read_pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918782806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918782806;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.416 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "367DD82372222511E3959FED50D1A21D")
    @Override
    public boolean markSupported() {
        boolean varB326B5062B2F0E69046810717534CB09_2136059320 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246385244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246385244;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.417 -0400", hash_original_method = "AA335ECE90F2C0243759B4C2341DEAEB", hash_generated_method = "6FC75D596CA3592ABDB6452257C64698")
    @Override
    public void mark(int limit) {
        addTaint(limit);
        marked_pos = read_pos;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.417 -0400", hash_original_method = "B5D6E2F2B60CF54FA8B6A301921FACA9", hash_generated_method = "8E66598714AB5518D80D85962020F8D6")
    public void mark() {
        marked_pos = read_pos;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.417 -0400", hash_original_method = "A27E7E8C3D531E39801BBCF5B4CC5B78", hash_generated_method = "693420C1CA7DDBF7BF7CBA32F5E0D8E9")
    @Override
    public void reset() {
        read_pos = marked_pos;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.418 -0400", hash_original_method = "86BACF12AABDF1D79A57ADD37C52BB94", hash_generated_method = "933DD4A682E7CABF050D3BCA5C001EEF")
    protected void removeFromMarkedPosition() {
        System.arraycopy(buffer, read_pos,
                buffer, marked_pos, read_pos_end - read_pos);
        read_pos_end -= (read_pos - marked_pos);
        read_pos = marked_pos;
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.419 -0400", hash_original_method = "0824C344C7EF76E18DAFC5A0824644C2", hash_generated_method = "EDC3D07E6F33FEABDE8BEA1AF9DE5175")
    @Override
    public int read() throws IOException {
    if(read_pos == read_pos_end)        
        {
            EndOfBufferException var2FD9D9218EBC95DE1840304BBDFC9EB5_13386513 = new EndOfBufferException();
            var2FD9D9218EBC95DE1840304BBDFC9EB5_13386513.addTaint(taint);
            throw var2FD9D9218EBC95DE1840304BBDFC9EB5_13386513;
        } 
        int varEDF9E7723DD041BD87E6398AEACEFB95_159087742 = (buffer[read_pos++] & 0xFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223674502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223674502;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.420 -0400", hash_original_method = "91CEDBDE7A81F4DCE85242430A46DCF1", hash_generated_method = "028C097533A258C029E8EDAD42181FC9")
    @Override
    public byte[] read(int length) throws IOException {
    if(length > available())        
        {
            EndOfBufferException var2FD9D9218EBC95DE1840304BBDFC9EB5_1166136128 = new EndOfBufferException();
            var2FD9D9218EBC95DE1840304BBDFC9EB5_1166136128.addTaint(taint);
            throw var2FD9D9218EBC95DE1840304BBDFC9EB5_1166136128;
        } 
        byte[] res = new byte[length];
        System.arraycopy(buffer, read_pos, res, 0, length);
        read_pos = read_pos + length;
        byte[] var9B207167E5381C47682C6B4F58A623FB_389860870 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1560438845 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1560438845;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.421 -0400", hash_original_method = "2AC89109B1F5C21FC0020B1393568717", hash_generated_method = "F1557D363BAE10C817D38ACA4EE189F5")
    @Override
    public int read(byte[] dst, int offset, int length) throws IOException {
        addTaint(offset);
        addTaint(dst[0]);
    if(length > available())        
        {
            EndOfBufferException var2FD9D9218EBC95DE1840304BBDFC9EB5_245287307 = new EndOfBufferException();
            var2FD9D9218EBC95DE1840304BBDFC9EB5_245287307.addTaint(taint);
            throw var2FD9D9218EBC95DE1840304BBDFC9EB5_245287307;
        } 
        System.arraycopy(buffer, read_pos, dst, offset, length);
        read_pos = read_pos + length;
        int var2FA47F7C65FEC19CC163B195725E3844_446556672 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8788403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8788403;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.421 -0400", hash_original_method = "AF6CB8DBEC021FC7528B8ED3F8431D0F", hash_generated_method = "2ACDA3F035E3A9FC3DD5633D9B6E6743")
    public void append(byte[] src) {
        addTaint(src[0]);
        append(src, 0, src.length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.422 -0400", hash_original_method = "2AF2E557DF862B37CD8412561C90BA0E", hash_generated_method = "80BAE1CD2D70C25E9B19F200E8997F07")
    private void append(byte[] src, int from, int length) {
        addTaint(from);
        addTaint(src[0]);
    if(read_pos == read_pos_end)        
        {
    if(write_pos_beg != write_pos)            
            {
                AlertException var62753D7B68B46D335DC288F6CA6B8280_1020381549 = new AlertException(
                    AlertProtocol.UNEXPECTED_MESSAGE,
                    new SSLHandshakeException(
                        "Handshake message has been received before "
                        + "the last oubound message had been sent."));
                var62753D7B68B46D335DC288F6CA6B8280_1020381549.addTaint(taint);
                throw var62753D7B68B46D335DC288F6CA6B8280_1020381549;
            } 
    if(read_pos < write_pos)            
            {
                read_pos = write_pos;
                read_pos_end = read_pos;
            } 
        } 
    if(read_pos_end + length > buff_size)        
        {
            enlargeBuffer(read_pos_end+length-buff_size);
        } 
        System.arraycopy(src, from, buffer, read_pos_end, length);
        read_pos_end += length;
        
        
            
                
                    
                    
                        
                        
            
            
                
                
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.423 -0400", hash_original_method = "7D810597598BCFC529CACE9B428759B7", hash_generated_method = "F10C7007A5E34FDD773FDB6E4B15CED8")
    private void enlargeBuffer(int size) {
        buff_size = (size < inc_buff_size)
            ? buff_size + inc_buff_size
            : buff_size + size;
        byte[] new_buff = new byte[buff_size];
        System.arraycopy(buffer, 0, new_buff, 0, buffer.length);
        buffer = new_buff;
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.423 -0400", hash_original_method = "B556221995277C3C7246E0F0C5588CBB", hash_generated_method = "BCBCCE972316FCF6E3ED61C98EDA9548")
    protected void clearBuffer() {
        read_pos = 0;
        marked_pos = 0;
        read_pos_end = 0;
        write_pos = 0;
        write_pos_beg = 0;
        Arrays.fill(buffer, (byte) 0);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.424 -0400", hash_original_method = "5D32524C92EB4CDA6DDBF787AA4026BF", hash_generated_method = "866747446009BAB34A3E91328E4879F7")
    private void check(int length) {
        addTaint(length);
    if(write_pos == write_pos_beg)        
        {
    if(read_pos != read_pos_end)            
            {
                AlertException varAF5D10BB12840AE996AC8724BF063613_462634224 = new AlertException(
                        AlertProtocol.INTERNAL_ERROR,
                        new SSLHandshakeException("Data was not fully read: "
                        + read_pos + " " + read_pos_end));
                varAF5D10BB12840AE996AC8724BF063613_462634224.addTaint(taint);
                throw varAF5D10BB12840AE996AC8724BF063613_462634224;
            } 
    if(write_pos_beg < read_pos_end)            
            {
                write_pos_beg = read_pos_end;
                write_pos = write_pos_beg;
            } 
        } 
    if(write_pos + length >= buff_size)        
        {
            enlargeBuffer(length);
        } 
        
        
            
                
                        
                        
                        
            
            
                
                
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.424 -0400", hash_original_method = "585ADF2190C2ED18E311DC7717079D3E", hash_generated_method = "50E8F06F9B2EC6BE2FD6E36ABAB0E9B3")
    public void write(byte b) {
        check(1);
        buffer[write_pos++] = b;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.425 -0400", hash_original_method = "D10825FCC1F6D574D203B7119B0DE21D", hash_generated_method = "746FA1D852B4462B02D4B11DE4F038B2")
    public void writeUint8(long n) {
        check(1);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.425 -0400", hash_original_method = "BC95F3A9D20B746C785DDB55CCD0B371", hash_generated_method = "5866BECFA5BEC5BCACD7708A89B8E0C2")
    public void writeUint16(long n) {
        check(2);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.426 -0400", hash_original_method = "5F803054AD541DA3DFDDE2CF3FE59841", hash_generated_method = "B27E2A86274DAC461A04AD89C4AE2BC0")
    public void writeUint24(long n) {
        check(3);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.427 -0400", hash_original_method = "F5CBF84A3DE853E04B44967F882D7399", hash_generated_method = "9F56E6BFB9DCC5E8C9071586A6904FDB")
    public void writeUint32(long n) {
        check(4);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.429 -0400", hash_original_method = "9B394B4CCC83FB2B8DCA345D732654D8", hash_generated_method = "C9F7F02983D8E0AD1829D109FA43876B")
    public void writeUint64(long n) {
        check(8);
        buffer[write_pos++] = (byte) ((n & 0x00ff00000000000000L) >> 56);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000000000L) >> 48);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000000000L) >> 40);
        buffer[write_pos++] = (byte) ((n & 0x00ff00000000L) >> 32);
        buffer[write_pos++] = (byte) ((n & 0x00ff000000) >> 24);
        buffer[write_pos++] = (byte) ((n & 0x00ff0000) >> 16);
        buffer[write_pos++] = (byte) ((n & 0x00ff00) >> 8);
        buffer[write_pos++] = (byte) (n & 0x00ff);
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.430 -0400", hash_original_method = "E2E038DF81C8876BEF1DC650925A08F9", hash_generated_method = "62CE06DF1672F4376F05B684697D9A29")
    public void write(byte[] vector) {
        check(vector.length);
        System.arraycopy(vector, 0, buffer, write_pos, vector.length);
        write_pos += vector.length;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.431 -0400", hash_original_method = "8D64F0C3C5F38A8BA7A92E3DA10323F4", hash_generated_method = "42E4E696D2BFAC6A39092165B4B2A4D9")
    public boolean hasData() {
        boolean varFC0938447DDB3704EEEB90CDB9306E91_170991112 = ((write_pos > write_pos_beg));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390404628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390404628;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.432 -0400", hash_original_method = "E6D2A8CE9FA7080A42A1984AB4D903A3", hash_generated_method = "3A7CC7B30E9099C8B1295562F0516DF7")
    public byte[] getData(int length) {
        byte[] res;
    if(write_pos - write_pos_beg < length)        
        {
            res = new byte[write_pos - write_pos_beg];
            System.arraycopy(buffer, write_pos_beg,
                    res, 0, write_pos-write_pos_beg);
            write_pos_beg = write_pos;
        } 
        else
        {
            res = new byte[length];
            System.arraycopy(buffer, write_pos_beg, res, 0, length);
            write_pos_beg += length;
        } 
        byte[] var9B207167E5381C47682C6B4F58A623FB_1674330226 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_324366847 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_324366847;
        
        
        
            
            
                    
            
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.432 -0400", hash_original_method = "9B1F555F297B463533438E17CA1DA8BA", hash_generated_method = "938FA22EBD8E2AEA998B411824B4DEC6")
    protected byte[] getDigestMD5() {
        synchronized
(md5)        {
            int len = (read_pos_end > write_pos)
                ? read_pos_end
                : write_pos;
            md5.update(buffer, 0, len);
            byte[] var1B356D866D0E3D52F9E5A877448C2565_1800770237 = (md5.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2037286213 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2037286213;
        } 
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.432 -0400", hash_original_method = "74B8780B4340381F62E79DEE30B1C1C3", hash_generated_method = "680B1661E924718DFCA792FF8C496F32")
    protected byte[] getDigestSHA() {
        synchronized
(sha)        {
            int len = (read_pos_end > write_pos)
                ? read_pos_end
                : write_pos;
            sha.update(buffer, 0, len);
            byte[] varF7A2BE41696CC35E0BB9AD20C75DEF7C_496058694 = (sha.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1590568623 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1590568623;
        } 
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.433 -0400", hash_original_method = "DDBF067C5B2E3F42A7068CF9EE336859", hash_generated_method = "C66F3CC51EE9C763E104379CA95687D5")
    protected byte[] getDigestMD5withoutLast() {
        synchronized
(md5)        {
            md5.update(buffer, 0, marked_pos);
            byte[] var1B356D866D0E3D52F9E5A877448C2565_1214889766 = (md5.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1034244723 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1034244723;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.433 -0400", hash_original_method = "BE851090505272B625E52E095FDF236D", hash_generated_method = "2982782AF8AC0A92182286A94190F66A")
    protected byte[] getDigestSHAwithoutLast() {
        synchronized
(sha)        {
            sha.update(buffer, 0, marked_pos);
            byte[] varF7A2BE41696CC35E0BB9AD20C75DEF7C_247886318 = (sha.digest());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_913893877 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_913893877;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.433 -0400", hash_original_method = "B51805E12EB2284C59279E2C362DB00D", hash_generated_method = "4875E0C3121D6260F310361FB9ECF4E9")
    protected byte[] getMessages() {
        int len = (read_pos_end > write_pos) ? read_pos_end : write_pos;
        byte[] res = new byte[len];
        System.arraycopy(buffer, 0, res, 0, len);
        byte[] var9B207167E5381C47682C6B4F58A623FB_480624212 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_940652284 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_940652284;
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.433 -0400", hash_original_field = "1BC29B36F623BA82AAF6724FD3B16718", hash_generated_field = "17962FC0CAF6059B3EB6A90549C3E142")

    private static MessageDigest md5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.433 -0400", hash_original_field = "CA794FB2D950ACF25C964ECC35F2D7E2", hash_generated_field = "A133435596333D642AF59DA1AC707533")

    private static MessageDigest sha;
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Could not initialize the Digest Algorithms.");
        }
    }
    
}

