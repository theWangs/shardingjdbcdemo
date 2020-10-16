package com.wang.shardingjdbcdemo.support;

import java.lang.annotation.*;

/**
 * 切换数据源注解
 *
 * @Author: meng
 * @Date: 2020-10-13 16:47
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DS {
    String name() default "defaultDataSource";
}
