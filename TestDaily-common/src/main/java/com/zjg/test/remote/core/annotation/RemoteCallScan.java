//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zjg.test.remote.core.annotation;

import com.zjg.test.remote.core.RemoteCallPackageRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({RemoteCallPackageRegistrar.class})
public @interface RemoteCallScan {

    @AliasFor(value = "basePackages")
    String[] value() default {};

    @AliasFor(value = "value")
    String[] basePackages() default {};
}
