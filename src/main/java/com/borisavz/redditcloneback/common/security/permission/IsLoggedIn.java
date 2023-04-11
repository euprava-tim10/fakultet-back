package com.borisavz.redditcloneback.common.security.permission;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public @interface IsLoggedIn {
}
