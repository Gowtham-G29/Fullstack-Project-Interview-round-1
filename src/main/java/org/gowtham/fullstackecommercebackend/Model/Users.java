package org.gowtham.fullstackecommercebackend.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String gender;
    private String state;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;
    private String latitude;
    private String longitude;
    private String trafficSource;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> orders;
}
