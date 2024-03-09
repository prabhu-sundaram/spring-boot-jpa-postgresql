package com.dm.springbootjpapostgresql.model.montaji;

import java.util.List;

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
@Table(name = "req_container")
public class Container{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;    
    private String serialNo;
    private String containerTypeId;
    private String containerNumber;
    private String storageTemperatureId;
    private int containerTotalQuantity;
    private int productsCount;
    private double containerTotalWeight;

    @OneToMany(mappedBy = "container", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContainerProduct> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_number", nullable = false)
    private RequestCPIP requestCPIP;    
}
