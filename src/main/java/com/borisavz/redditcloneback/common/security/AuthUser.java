package com.borisavz.redditcloneback.common.security;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthUser {

    private long id;
    private String role;
    private long fakultetId;

}
