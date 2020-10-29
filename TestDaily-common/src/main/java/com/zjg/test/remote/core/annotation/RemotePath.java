package com.zjg.test.remote.core.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  * @description: 远程调用方法的path
  * @author zjg
  * @date 2020/4/23 16:39
  */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RemotePath {


    @AliasFor(value = "methodUrl")
    String value() default "";

    @AliasFor(value = "value")
    String methodUrl() default "";

}
