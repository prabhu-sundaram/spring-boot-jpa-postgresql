package com.dm.springbootjpapostgresql.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalResponse<T> {

    private T data;
    private Meta meta;

    public GlobalResponse(T data, Pagination pagination) {
        this.data = data;
        this.meta = new Meta(pagination);
    }

    public GlobalResponse(T data) {
        this.data = data;
    }

    public GlobalResponse(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }
}
