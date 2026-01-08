package com.dm.springbootjpapostgresql.model.entity.enumeration;

public enum Status {
    Active("Active"),
    Inactive("Inactive");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
