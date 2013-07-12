package android.test;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) @Retention(RetentionPolicy.RUNTIME) public @interface RepetitiveTest {
    
    int numIterations() default 1;
}
