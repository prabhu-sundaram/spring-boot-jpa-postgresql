package com.dm.springbootjpapostgresql.model.montaji;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_batch")
public class ProductBatch{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;    
    private int serialNo;
    private double itemsUnitWeight;
    private int itemsQuantity;
    private double itemsTotalWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private ContainerProduct containerProduct;       
}
