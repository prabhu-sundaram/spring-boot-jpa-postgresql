package com.dm.springbootjpapostgresql.utils;

import java.sql.Date;

import org.modelmapper.AbstractConverter;

public class DateToStringConverter extends AbstractConverter<Date, String> {
    @Override
    protected String convert(Date source) {
        return source.toString();
    }
}
