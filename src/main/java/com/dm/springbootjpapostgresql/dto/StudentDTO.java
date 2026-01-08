package com.dm.springbootjpapostgresql.dto;

import com.dm.springbootjpapostgresql.model.entity.Guardian;

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
public class StudentDTO
{
    private Long studentId;
	private String firstName;
	private String lastName;
    private String email;
    //private Guardian guardian;
}