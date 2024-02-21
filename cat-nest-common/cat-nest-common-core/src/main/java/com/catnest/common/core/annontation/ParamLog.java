package com.catnest.common.core.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamLog {

    /**
     * 方法描述
     */
    String methodDesc() default "";

    /**
     * 激活打印返回参数
     */
    boolean enableLogRetVal() default false;

}
