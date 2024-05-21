package com.dm.springbootjpapostgresql.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    // private IdGenerator() {
    // }
    private static final String DATE_FORMAT = "yyyyMMdd";
    private static AtomicLong counter = new AtomicLong(0);    

    public static BigDecimal generateUniqueId() {
        // Generate a UUID
        UUID uuid = UUID.randomUUID();
        // Return the most significant bits of the UUID
        return new BigDecimal(uuid.getMostSignificantBits());
    }

  public static String generateUniqueId2(String service) {
    StringBuilder builder = new StringBuilder();
    builder.append(service);
    builder.append("-");
    builder.append(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
    builder.append("-");
    builder.append(String.format("%04d", counter.incrementAndGet()));
    return builder.toString();
  }    

}
