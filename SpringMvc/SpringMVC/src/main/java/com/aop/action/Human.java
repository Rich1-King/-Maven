package com.aop.action;

import java.lang.annotation.*;

/**
 * Created by rich1 on 7/18/16.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Human{

     String name();
}
