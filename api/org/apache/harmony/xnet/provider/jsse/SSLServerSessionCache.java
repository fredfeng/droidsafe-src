package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.net.ssl.SSLSession;

public interface SSLServerSessionCache {

  
  public byte[] getSessionData(byte[] id);

  
  public void putSessionData(SSLSession session, byte[] sessionData);
}
