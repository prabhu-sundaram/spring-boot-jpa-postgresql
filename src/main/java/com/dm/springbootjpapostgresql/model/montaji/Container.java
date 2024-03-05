package com.dm.springbootjpapostgresql.model.montaji;

import java.util.ArrayList;
import java.util.List;

import com.dm.springbootjpapostgresql.model.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "req_container")
public class Container{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;    
    private String serialNo;
    private String containerTypeId;
    private String containerNumber;
    private String storageTemperatureId;
    private int containerTotalQuantity;
    private int productsCount;
    private double containerTotalWeight;

    @OneToMany(mappedBy = "req_container", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContainerProduct> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private RequestCPIP requestCPIP;    
}
