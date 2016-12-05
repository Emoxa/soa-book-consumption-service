package com.filrouge.consumption.entity;

import java.util.Optional;

public enum Period {
    hour("hour"), day("day"), week("week"), month("month"), year("year");

    private final String name;

    Period(String s) {
        name = s;
    }

    public static Optional<Period> getOptionalValueOf(String name) {
        return EnumUtil.getOptionalValueOf(Period.class, name);
    }

    public boolean equalsName(String otherName) {
        return otherName != null && name.equals(otherName);
    }

    public boolean equalsName(String otherName) {
        return otherName != null && name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
