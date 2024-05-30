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
@Table(name = "container_product")
public class ContainerProduct{

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;

    private String barcode;
    private String productId;
    private String groupId;
    private String categoryId;
    private String subCategoryId;
    private String countryId;
    private String brandId;
    @Column(nullable=true)
    private int noOfBatches;
    @Column(nullable=true)
    private int noOfBatches2;
    private int productTotalQuantity;
    private double productUnitWeight;
    private double productTotalWeight;

    @OneToMany(mappedBy = "containerProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductBatch> batches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_id", nullable = false, referencedColumnName = "id")
    private Container container;       

    public void addProductBatch(ProductBatch productBatch)
    {
        batches.add(productBatch);
        updateNoOfBatches2();
    }
    private void updateNoOfBatches2()
    {
        noOfBatches2 = batches.size();
    }
}
