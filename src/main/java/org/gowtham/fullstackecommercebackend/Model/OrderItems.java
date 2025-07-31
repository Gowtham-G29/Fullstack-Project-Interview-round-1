package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;
    private OffsetDateTime createdAt;
    private OffsetDateTime shippedAt;
    private OffsetDateTime deliveredAt;
    private OffsetDateTime returnedAt;
    private BigDecimal salePrice;

//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false)
//    private Orders order;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Users userId;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Products productId;
//
//    @ManyToOne
//    @JoinColumn(name = "inventory_item_id")
//    private InventoryItem inventoryItem;
}
