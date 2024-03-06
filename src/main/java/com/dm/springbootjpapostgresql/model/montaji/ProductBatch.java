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
@Table(name = "product_batch")
public class ProductBatch{
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;    

    private int serialNo;
    private double itemsUnitWeight;
    private int itemsQuantity;
    private double itemsTotalWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_product_id", nullable = false)
    private ContainerProduct containerProduct;       
}
