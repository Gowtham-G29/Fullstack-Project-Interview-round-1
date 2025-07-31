package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private String status;
    private String gender;
    private OffsetDateTime createdAt;
    private OffsetDateTime shippedAt;
    private OffsetDateTime deliveredAt;
    private int numberOfItem;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private Users user;
//
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<OrderItems> items = new ArrayList<>();
}
