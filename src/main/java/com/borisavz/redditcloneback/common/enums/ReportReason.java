package com.borisavz.redditcloneback.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReportReason {
    BREAKES_RULES, HARASSMENT, HATE, SHARING_PERSONAL_INFORMATION,
    IMPERSONATION, COPYRIGHT_VIOLATION, TRADEMARK_VIOLATION, SPAM,
    SELF_HARM_OR_SUICIDE, OTHER;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
