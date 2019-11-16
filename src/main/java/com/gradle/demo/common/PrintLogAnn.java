package com.gradle.demo.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintLogAnn {

    /**
     * 是否需要打印日志
     * @return
     */
    boolean printLog() default true;

    /**
     * 是否需要打印返回值日志
     * @return
     */
    boolean printReturnLog() default true;
}
