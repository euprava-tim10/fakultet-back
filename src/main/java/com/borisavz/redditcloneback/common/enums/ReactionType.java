package com.borisavz.redditcloneback.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReactionType {
    UPVOTE, DOWNVOTE;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
