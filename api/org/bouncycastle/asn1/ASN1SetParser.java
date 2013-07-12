package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public interface ASN1SetParser
    extends DEREncodable, InMemoryRepresentable
{
    public DEREncodable readObject()
        throws IOException;
}
