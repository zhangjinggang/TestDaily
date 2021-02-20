package com.zjg.dao.config;

import java.lang.annotation.*;

/**
 * @author Sj
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String value() default "";

}
