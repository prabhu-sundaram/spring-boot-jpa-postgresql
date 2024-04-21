package com.dm.springbootjpapostgresql.example.beans;


import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.dm.springbootjpapostgresql.example.jacksonExample.CustomDateDeserializer;
import com.dm.springbootjpapostgresql.example.jacksonExample.CustomDateSerializer;
import com.dm.springbootjpapostgresql.example.jacksonExample.CustomLocalDateTimeSerializer;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Event2 {
private String name;
//@JsonFormat
//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
@JsonSerialize(using = CustomDateSerializer.class)
@JsonDeserialize(using = CustomDateDeserializer.class)
private Date eventDate;

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
public LocalDateTime eventDate2;

public Event2(String name, Date eventDate, LocalDateTime eventDate2) {
	super();
	this.name = name;
	this.eventDate = eventDate;
	this.eventDate2 = eventDate2;
}

public Event2(String name, Date eventDate) {
	super();
	this.name = name;
	this.eventDate = eventDate;
}

public Event2() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getEventDate() {
	return eventDate;
}
public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
}
public LocalDateTime getEventDate2() {
	return eventDate2;
}
public void setEventDate2(LocalDateTime eventDate2) {
	this.eventDate2 = eventDate2;
}
@Override
public String toString() {
	return "Event2 [name=" + name + ", eventDate=" + eventDate + ", eventDate2=" + eventDate2 + ", getName()="
			+ getName() + ", getEventDate()=" + getEventDate() + ", getEventDate2()=" + getEventDate2() + "]";
}
}
