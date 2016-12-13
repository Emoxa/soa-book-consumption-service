package com.filrouge.consumption.entity;

import java.util.Optional;

public enum Currency {
    Euro("euro"), Dollar("dollar"), Yuan("yuan"), Pound("pound");

    private final String name;

    Currency(String s) {
        name = s;
    }

    public static Optional<Currency> getOptionalValueOf(String name) {
        return EnumUtil.getOptionalValueOf(Currency.class, name);
    }

    public boolean equalsName(String otherName) {
        return otherName != null && name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
