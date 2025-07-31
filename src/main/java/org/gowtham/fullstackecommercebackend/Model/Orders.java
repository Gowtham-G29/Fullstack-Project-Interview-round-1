package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> items;
}
