package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

public interface CookieStore {

    
    void addCookie(Cookie cookie);

    
    List<Cookie> getCookies();

    
    boolean clearExpired(Date date);

    
    void clear();
    
}
