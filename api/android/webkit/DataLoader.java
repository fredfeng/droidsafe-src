package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.http.EventHandler;
import com.android.internal.R;
import java.io.ByteArrayInputStream;
import libcore.io.Base64;

class DataLoader extends StreamLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.837 -0400", hash_original_method = "973C5174F409BF73FE3F5C468E90899A", hash_generated_method = "287DEED07BE2E6E0D799B125C286950E")
      DataLoader(String dataUrl, LoadListener loadListener) {
        super(loadListener);
        addTaint(loadListener.getTaint());
        addTaint(dataUrl.getTaint());
        String url = dataUrl.substring("data:".length());
        byte[] data = null;
        int commaIndex = url.indexOf(',');
    if(commaIndex != -1)        
        {
            String contentType = url.substring(0, commaIndex);
            data = url.substring(commaIndex + 1).getBytes();
            loadListener.parseContentTypeHeader(contentType);
    if("base64".equals(loadListener.transferEncoding()))            
            {
                data = Base64.decode(data);
            } 
        } 
        else
        {
            data = url.getBytes();
        } 
    if(data != null)        
        {
            mDataStream = new ByteArrayInputStream(data);
            mContentLength = data.length;
        } 
        
        
        
        
        
            
            
            
            
                
            
        
            
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.838 -0400", hash_original_method = "741CD292254249FEBDFDE203F8AC2D5E", hash_generated_method = "0A9A69EFE4F5D625621799AE055847E1")
    @Override
    protected boolean setupStreamAndSendStatus() {
    if(mDataStream != null)        
        {
            mLoadListener.status(1, 1, 200, "OK");
            boolean varB326B5062B2F0E69046810717534CB09_1702855669 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078713228 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078713228;
        } 
        else
        {
            mLoadListener.error(EventHandler.ERROR,
                    mContext.getString(R.string.httpError));
            boolean var68934A3E9455FA72420237EB05902327_1115559856 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855836191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855836191;
        } 
        
        
            
            
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.839 -0400", hash_original_method = "2B11D339C271386CE83AD39A9189005C", hash_generated_method = "DD3C4AC742A0B9EC492618A2D675A09F")
    @Override
    protected void buildHeaders(android.net.http.Headers h) {
        addTaint(h.getTaint());
        
    }

    
}

