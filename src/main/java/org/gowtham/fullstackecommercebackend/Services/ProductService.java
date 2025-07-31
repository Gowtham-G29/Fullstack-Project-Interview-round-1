package org.gowtham.fullstackecommercebackend.Services;

import org.gowtham.fullstackecommercebackend.Model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Products> getAllProducts() throws Exception;
    Optional<Products> getProductById(Long id) throws Exception;
}
