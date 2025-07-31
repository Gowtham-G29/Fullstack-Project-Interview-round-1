package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory_items")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime createdAt;
    private OffsetDateTime soldAt;
    private BigDecimal cost;

    private String productCategory;
    private String productName;
    private String productBrand;
    private BigDecimal productRetailPrice;
    private String productDepartment;
    private String productSku;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Products product;
//
//    @ManyToOne
//    @JoinColumn(name = "distribution_center_id")
//    private DistributionCenters distributionCenter;
}
