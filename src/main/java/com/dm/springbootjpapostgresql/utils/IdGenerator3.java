package com.dm.springbootjpapostgresql.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdGenerator3 {
    @Autowired
    JdbcTemplate jdbcTemplate;


    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final IdGenerator3 instance = new IdGenerator3(); // Singleton instance created here

    private IdGenerator3() {
      // Private constructor to prevent external instantiation (optional)
    }
    public static IdGenerator3 getInstance() {
      return instance;
    }    
  public String generateRequestNo(String service) {
    StringBuilder builder = new StringBuilder();
    builder.append(service);
    builder.append("-");
    builder.append(LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
    builder.append("-");
    builder.append(String.format("%04d", getNextSequenceValue(service)));
    return builder.toString();
  } 

  private long getNextSequenceValue(String service) {
    Long sequenceValue=null;
    if(service=="CPIP") {
    sequenceValue = jdbcTemplate.queryForObject("SELECT CPIP_SEQ.NEXTVAL FROM DUAL", Long.class);
    }
    if (sequenceValue == null) {
      throw new RuntimeException("Failed to retrieve next sequence value");
    }
    return sequenceValue;
  }

}
