package org.apache.http.client.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HttpContext;

public class ResponseProcessCookies implements HttpResponseInterceptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.309 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.310 -0400", hash_original_method = "4D600FAEAE45D81498CB22DB2E88FC55", hash_generated_method = "24DEF7D8C332AA18A2A34FD1AC38543A")
    public  ResponseProcessCookies() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.311 -0400", hash_original_method = "DEAF5EA61A5D1778D6CCA56F636FFAFD", hash_generated_method = "3E3F9302A6D67544DB3AA3AED8AD7B96")
    public void process(final HttpResponse response, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_58493223 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_58493223.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_58493223;
        } 
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_935335295 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_935335295.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_935335295;
        } 
        CookieStore cookieStore = (CookieStore) context.getAttribute(
                ClientContext.COOKIE_STORE);
    if(cookieStore == null)        
        {
            this.log.info("Cookie store not available in HTTP context");
            return;
        } 
        CookieSpec cookieSpec = (CookieSpec) context.getAttribute(
                ClientContext.COOKIE_SPEC);
    if(cookieSpec == null)        
        {
            this.log.info("CookieSpec not available in HTTP context");
            return;
        } 
        CookieOrigin cookieOrigin = (CookieOrigin) context.getAttribute(
                ClientContext.COOKIE_ORIGIN);
    if(cookieOrigin == null)        
        {
            this.log.info("CookieOrigin not available in HTTP context");
            return;
        } 
        HeaderIterator it = response.headerIterator(SM.SET_COOKIE);
        processCookies(it, cookieSpec, cookieOrigin, cookieStore);
    if(cookieSpec.getVersion() > 0)        
        {
            it = response.headerIterator(SM.SET_COOKIE2);
            processCookies(it, cookieSpec, cookieOrigin, cookieStore);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.313 -0400", hash_original_method = "91DFC6E3C42B7F0C9ED2CF0B4905D6AD", hash_generated_method = "8412E5DDD380FA295A44D44A1DFF147E")
    private void processCookies(
            final HeaderIterator iterator, 
            final CookieSpec cookieSpec,
            final CookieOrigin cookieOrigin,
            final CookieStore cookieStore) {
        addTaint(cookieStore.getTaint());
        addTaint(cookieOrigin.getTaint());
        addTaint(cookieSpec.getTaint());
        addTaint(iterator.getTaint());
        while
(iterator.hasNext())        
        {
            Header header = iterator.nextHeader();
            try 
            {
                List<Cookie> cookies = cookieSpec.parse(header, cookieOrigin);
for(Cookie cookie : cookies)
                {
                    try 
                    {
                        cookieSpec.validate(cookie, cookieOrigin);
                        cookieStore.addCookie(cookie);
    if(this.log.isDebugEnabled())                        
                        {
                            this.log.debug("Cookie accepted: \""
                                    + cookieToString(cookie) + "\". ");
                        } 
                    } 
                    catch (MalformedCookieException ex)
                    {
    if(this.log.isWarnEnabled())                        
                        {
                            this.log.warn("Cookie rejected: \""
                                    + cookieToString(cookie) + "\". " + ex.getMessage());
                        } 
                    } 
                } 
            } 
            catch (MalformedCookieException ex)
            {
    if(this.log.isWarnEnabled())                
                {
                    this.log.warn("Invalid cookie header: \""
                            + header + "\". " + ex.getMessage());
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.314 -0400", hash_original_method = "7F26B81C9250A7120577E4D4C011F353", hash_generated_method = "C84218484C9FE1D9FA742D09799D3F52")
    private String cookieToString(Cookie cookie) {
        addTaint(cookie.getTaint());
String var0ABBA5CC7B1A5006D5506D524CF2B7A5_343886443 =         cookie.getClass().getSimpleName()
                + "[version=" + cookie.getVersion()
                + ",name=" + cookie.getName()
                + ",domain=" + cookie.getDomain()
                + ",path=" + cookie.getPath()
                + ",expiry=" + cookie.getExpiryDate()
                + "]";
        var0ABBA5CC7B1A5006D5506D524CF2B7A5_343886443.addTaint(taint);
        return var0ABBA5CC7B1A5006D5506D524CF2B7A5_343886443;
        
        
                
                
                
                
                
                
    }

    
}

