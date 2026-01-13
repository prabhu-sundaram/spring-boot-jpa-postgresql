package com.dm.springbootjpapostgresql.dto;

import java.time.OffsetDateTime;

public record CategoryRecord(
    Long id,
    String name,
    String email,
    String body,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
    )
    {

    }