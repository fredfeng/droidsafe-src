package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface RouteHeader extends HeaderAddress, Header, Parameters {
    String NAME = "Route";
}
