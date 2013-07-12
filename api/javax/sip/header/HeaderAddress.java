package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.address.Address;

public interface HeaderAddress {
    Address getAddress();
    void setAddress(Address address);
}
