package org.gowtham.fullstackecommercebackend.Repository;

import org.gowtham.fullstackecommercebackend.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Products, Long> {
}
