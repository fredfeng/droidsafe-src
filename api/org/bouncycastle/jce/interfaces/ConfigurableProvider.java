package org.bouncycastle.jce.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ConfigurableProvider
{
    static final String      THREAD_LOCAL_EC_IMPLICITLY_CA = "threadLocalEcImplicitlyCa";   
    static final String      EC_IMPLICITLY_CA = "ecImplicitlyCa";

    void setParameter(String parameterName, Object parameter);
}
