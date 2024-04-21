package com.dm.springbootjpapostgresql.example.beans;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.dm.springbootjpapostgresql.example.jacksonExample.CustomDateDeserializer;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Event {
private String name;
private Date eventDate;
public Event(String name, Date eventDate) {
	super();
	this.name = name;
	this.eventDate = eventDate;
}
public Event() {
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
@Override
public String toString() {
	return "Event [name=" + name + ", eventDate=" + eventDate + ", getName()=" + getName() + ", getEventDate()="
			+ getEventDate() + "]";
}
}
