package com.dm.springbootjpapostgresql.model.montaji;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "req_preapproval")
public class PreApproval{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;    
    private String dip;
    private long dipWarehouseId;
    private String releaseWithDetention;
    private long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private long sampleDetentionWarehouseId;
}
