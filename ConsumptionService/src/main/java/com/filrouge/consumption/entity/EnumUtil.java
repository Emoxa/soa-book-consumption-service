package com.filrouge.consumption.entity;

import java.util.Optional;

public final class EnumUtil {
    static public <T extends Enum<T>> Optional<T> getOptionalValueOf(Class<T> enumType, String name) {
        try {
            return Optional.of(Enum.valueOf(enumType, name));
        } catch (NullPointerException ex) {
            return Optional.empty();
        }
    }
}
