package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.Header;
import javax.sip.header.HeaderAddress;
import javax.sip.header.Parameters;

public interface ServiceRouteHeader extends HeaderAddress, Parameters, Header {

    
    public final static String NAME = "Service-Route";

}
