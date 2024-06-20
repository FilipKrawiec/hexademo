package com.krawart.hexademo.common.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.data.annotation.Immutable;

/**
 * Event object with information about some important event happened in system and consumable by listeners
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Immutable
public @interface DomainEvent {
}
