package com.dm.springbootjpapostgresql.model.entity.montaji;

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
    private Long dipWarehouseId;
    private String releaseWithDetention;
    @Column(name = "release_with_detention_wh_id")
    private Long releaseWithDetentionWarehouseId;
    private String sampleDetention;
    private Long sampleDetentionWarehouseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_number", nullable = false)
    private RequestCPIP requestCPIP;        
}
