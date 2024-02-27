package com.dm.springbootjpapostgresql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Page {
    private List<Post2> posts;
    private Integer totalPage;
    private Integer currentPage;
    private Long total;
}
