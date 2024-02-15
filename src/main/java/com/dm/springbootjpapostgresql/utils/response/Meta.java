package com.dm.springbootjpapostgresql.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta implements Serializable {

    private Pagination pagination;

    public Meta() {
    }

    public Meta(Pagination pagination) {
        this.pagination = pagination;
    }
}
