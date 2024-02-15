package com.dm.springbootjpapostgresql.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagination implements Serializable {

    private Integer itemsPerPage;
    private Integer currentPageNumber;
    private Long totalItemCount;
    private Integer totalPageCount;

    public Pagination(Integer itemsPerPage, Integer currentPageNumber, Long totalItemCount, Integer totalPageCount) {
        this.itemsPerPage = itemsPerPage;
        this.currentPageNumber = currentPageNumber + 1; // Page Start With "0" Index
        this.totalItemCount = totalItemCount;
        this.totalPageCount = totalPageCount;
    }
}
