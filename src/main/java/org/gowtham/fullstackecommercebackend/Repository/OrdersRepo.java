package org.gowtham.fullstackecommercebackend.Repository;

import org.gowtham.fullstackecommercebackend.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdersRepo extends JpaRepository<Orders, Long> {
}
