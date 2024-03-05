package com.dm.springbootjpapostgresql.model.montaji;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "req_cpip")
public class RequestCPIP {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;    
    private String consignmentPurposeId;   

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_number", nullable = false)
    private Request request;
}
