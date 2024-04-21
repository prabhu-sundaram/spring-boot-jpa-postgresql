package com.dm.springbootjpapostgresql.example.logbackExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExample {
    private static Logger logger = LoggerFactory.getLogger(LogbackExample.class);

    public static void main(String[] args) {
        logger.trace("Trace log message");    	
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.warn("warn log message");
        logger.error("Error log message");
        //logger.fatal("fatal log message");
    }
}
