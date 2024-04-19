package com.dm.springbootjpapostgresql.utils;

import java.math.BigDecimal;
import java.util.UUID;

public class IdGenerator {
    private IdGenerator() {
    }

    public static BigDecimal generateUniqueId() {
        // Generate a UUID
        UUID uuid = UUID.randomUUID();
        // Return the most significant bits of the UUID
        return new BigDecimal(uuid.getMostSignificantBits());
    }
}
