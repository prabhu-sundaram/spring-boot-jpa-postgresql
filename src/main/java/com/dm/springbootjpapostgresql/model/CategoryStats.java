package com.dm.springbootjpapostgresql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryStats {
    private String tags;
    private Long totalPosts;
    private String averageViews;
}
