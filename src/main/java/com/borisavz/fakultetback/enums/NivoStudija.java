package com.borisavz.fakultetback.enums;

public enum NivoStudija {
    OSNOVNE, MASTER, DOKTORSKE;

    public boolean veciOd(NivoStudija other) {
        if(other == null)
            return true;

        return this.ordinal() > other.ordinal();
    }
}
