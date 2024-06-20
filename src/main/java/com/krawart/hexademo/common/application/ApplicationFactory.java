package com.krawart.hexademo.common.application;

import java.lang.annotation.*;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ApplicationFactory {
  @AliasFor(annotation = Component.class)
  String value() default "";
}
