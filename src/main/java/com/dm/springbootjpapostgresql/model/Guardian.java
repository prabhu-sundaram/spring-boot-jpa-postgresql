package com.dm.springbootjpapostgresql.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor


@AttributeOverrides(
{
        @AttributeOverride(
        name="name",
        column=@Column(name="guardian_name")
        ),
        @AttributeOverride(
        name="email",
        column=@Column(name="guardian_email")
        ),
        @AttributeOverride(
        name="mobile",
        column=@Column(name="guardian_mobile")
        )
}          
)
public class Guardian {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;    
    private String name;
    private String email;
    private String mobile;
}
