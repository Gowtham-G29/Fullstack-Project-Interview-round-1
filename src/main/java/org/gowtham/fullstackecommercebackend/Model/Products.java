package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cost;
    private String category;
    private String name;
    private String brand;
    private String retailPrice;
//    private String department;
    private String sku;

//    @ManyToOne
//    @JoinColumn(name = "distribution_center_id")
//    private DistributionCenters distributionCenter;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

}
