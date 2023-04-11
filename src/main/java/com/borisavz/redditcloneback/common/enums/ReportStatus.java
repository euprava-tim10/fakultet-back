package com.borisavz.redditcloneback.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReportStatus {
    PENDING, ACCEPTED, REJECTED;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
