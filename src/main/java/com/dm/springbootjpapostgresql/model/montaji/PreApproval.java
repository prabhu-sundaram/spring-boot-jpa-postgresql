package com.dm.springbootjpapostgresql.model.montaji;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "req_preapproval")
public class PreApproval{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;    
    private String dip;
    private long dipWarehouseId;
    private String releaseWithDetention;
    private long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private long sampleDetentionWarehouseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_number", nullable = false)
    private RequestCPIP requestCPIP;        
}
