package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import libcore.net.UriCodec;

public class FileURLConnection extends URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.890 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.890 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.890 -0400", hash_original_field = "37DD3CB77D31BF2E80399C3B748B5F16", hash_generated_field = "99508BAC072434E4BF52703BB1174C03")

    private int length = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.890 -0400", hash_original_field = "F0F18990052D31406E964D776FD3A36D", hash_generated_field = "3949ABAC0B1DE58EC6BD730E294BB79C")

    private boolean isDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.890 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "96BA6FFE95348C93D489804764910CBE")

    private FilePermission permission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.891 -0400", hash_original_method = "ECDCE15AD3E40A66FECAA373F1AD69DD", hash_generated_method = "4F166745F09965E9EE46DA91F5F6B516")
    public  FileURLConnection(URL url) {
        super(url);
        fileName = url.getFile();
    if(fileName == null)        
        {
            fileName = "";
        } 
        fileName = UriCodec.decode(fileName);
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.892 -0400", hash_original_method = "9A475DD1FCE4CCB36A5D73E904D3A34C", hash_generated_method = "CFA792195BF7265F672B928B6B86031F")
    @Override
    public void connect() throws IOException {
        File f = new File(fileName);
    if(f.isDirectory())        
        {
            isDir = true;
            is = getDirectoryListing(f);
        } 
        else
        {
            is = new BufferedInputStream(new FileInputStream(f));
            long lengthAsLong = f.length();
            length = lengthAsLong <= Integer.MAX_VALUE ? (int) lengthAsLong : Integer.MAX_VALUE;
        } 
        connected = true;
        
        
        
            
            
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.892 -0400", hash_original_method = "686027F78C1D594BA8DD041F116549D4", hash_generated_method = "17A3174953BE6BDC77E79302CEDA78CD")
    @Override
    public int getContentLength() {
        try 
        {
    if(!connected)            
            {
                connect();
            } 
        } 
        catch (IOException e)
        {
        } 
        int var2FA47F7C65FEC19CC163B195725E3844_1240906566 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213093753 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213093753;
        
        
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.893 -0400", hash_original_method = "72F889733CD7FE79958D9F6D8BD5D3FB", hash_generated_method = "1B175F38DD38F1C0123F8DD1921016EF")
    @Override
    public String getContentType() {
        try 
        {
    if(!connected)            
            {
                connect();
            } 
        } 
        catch (IOException e)
        {
String var74BE35FB698BCBEC5E595F7D368A5F61_1157295135 =             "content/unknown";
            var74BE35FB698BCBEC5E595F7D368A5F61_1157295135.addTaint(taint);
            return var74BE35FB698BCBEC5E595F7D368A5F61_1157295135;
        } 
    if(isDir)        
        {
String varF583FE76B1E99A18DF158173F36BC8DC_1352583566 =             "text/plain";
            varF583FE76B1E99A18DF158173F36BC8DC_1352583566.addTaint(taint);
            return varF583FE76B1E99A18DF158173F36BC8DC_1352583566;
        } 
        String result = guessContentTypeFromName(url.getFile());
    if(result != null)        
        {
String varDC838461EE2FA0CA4C9BBB70A15456B0_1037439207 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1037439207.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1037439207;
        } 
        try 
        {
            result = guessContentTypeFromStream(is);
        } 
        catch (IOException e)
        {
        } 
    if(result != null)        
        {
String varDC838461EE2FA0CA4C9BBB70A15456B0_1761939358 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1761939358.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1761939358;
        } 
String var74BE35FB698BCBEC5E595F7D368A5F61_1916685501 =         "content/unknown";
        var74BE35FB698BCBEC5E595F7D368A5F61_1916685501.addTaint(taint);
        return var74BE35FB698BCBEC5E595F7D368A5F61_1916685501;
        
        
            
                
            
        
            
        
        
            
        
        
        
            
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.894 -0400", hash_original_method = "D31BC01A8E6F1896A7501EEF99417267", hash_generated_method = "EEFC7393B469A9133F58F22F960406C4")
    private InputStream getDirectoryListing(File f) {
        addTaint(f.getTaint());
        String fileList[] = f.list();
        ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        out.print("<title>Directory Listing</title>\n");
        out.print("<base href=\"file:");
        out.print(f.getPath().replace('\\', '/') + "/\"><h1>" + f.getPath()
                + "</h1>\n<hr>\n");
        int i;
for(i = 0;i < fileList.length;i++)
        {
            out.print(fileList[i] + "<br>\n");
        } 
        out.close();
InputStream var3844484F7CAF8650F3CB9D0A65F2D71C_1549794519 =         new ByteArrayInputStream(bytes.toByteArray());
        var3844484F7CAF8650F3CB9D0A65F2D71C_1549794519.addTaint(taint);
        return var3844484F7CAF8650F3CB9D0A65F2D71C_1549794519;
        
        
        
        
        
        
        
                
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.895 -0400", hash_original_method = "632E8A34CACC91F3F004CEC65E6938CD", hash_generated_method = "502C333E8DC9ECFD26398130FD1A194B")
    @Override
    public InputStream getInputStream() throws IOException {
    if(!connected)        
        {
            connect();
        } 
InputStream varFEDEDC0F36E8CADECC99C26A1426338D_564512792 =         is;
        varFEDEDC0F36E8CADECC99C26A1426338D_564512792.addTaint(taint);
        return varFEDEDC0F36E8CADECC99C26A1426338D_564512792;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.896 -0400", hash_original_method = "FD3C5E750D9B5BE3AE6CD98B1BC8C55C", hash_generated_method = "20E140CE472DD65C6A55FF827DA1CDA0")
    @Override
    public java.security.Permission getPermission() throws IOException {
    if(permission == null)        
        {
            String path = fileName;
    if(File.separatorChar != '/')            
            {
                path = path.replace('/', File.separatorChar);
            } 
            permission = new FilePermission(path, "read");
        } 
java.security.Permission varF950FF3A88BA107D0E5EEB7D5554678A_1039490666 =         permission;
        varF950FF3A88BA107D0E5EEB7D5554678A_1039490666.addTaint(taint);
        return varF950FF3A88BA107D0E5EEB7D5554678A_1039490666;
        
        
            
            
                
            
            
        
        
    }

    
}

