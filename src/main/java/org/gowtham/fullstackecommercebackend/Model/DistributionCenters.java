package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "distribution_centers")
public class DistributionCenters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String latitude;
    private String longitude;

//    @OneToMany(mappedBy = "distributionCenter", cascade = CascadeType.ALL)
//    private List<Products> products;
//
//    @OneToMany(mappedBy = "distributionCenter", cascade = CascadeType.ALL)
//    private List<InventoryItem> inventoryItems;
}
