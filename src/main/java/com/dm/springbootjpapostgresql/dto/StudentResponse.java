package com.dm.springbootjpapostgresql.dto;

import java.util.List;
    
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse
{
private List<StudentDTO> content;
private int pageNo;
private int pageSize;
private Long totalElements;
private int totalPages;
private boolean last;
}
