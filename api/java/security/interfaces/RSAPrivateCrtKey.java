package java.security.interfaces;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public interface RSAPrivateCrtKey extends RSAPrivateKey {

    
    public static final long serialVersionUID = -5682214253527700368L;

    
    public BigInteger getCrtCoefficient();

    
    public BigInteger getPrimeP();

    
    public BigInteger getPrimeQ();

    
    public BigInteger getPrimeExponentP();

    
    public BigInteger getPrimeExponentQ();

    
    public BigInteger getPublicExponent();
}
