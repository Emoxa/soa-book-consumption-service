package com.filrouge.consumption.entity;

import java.util.Optional;

public enum ConsumptionMode {
    peak("peak"), offpeak("offpeak");

    private final String name;

    ConsumptionMode(String s) {
        name = s;
    }

    public static Optional<ConsumptionMode> getOptionalValueOf(String name) {
        return EnumUtil.getOptionalValueOf(ConsumptionMode.class, name);
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
