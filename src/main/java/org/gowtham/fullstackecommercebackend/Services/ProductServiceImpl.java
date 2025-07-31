package org.gowtham.fullstackecommercebackend.Services;

import org.gowtham.fullstackecommercebackend.Model.Products;
import org.gowtham.fullstackecommercebackend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Products> getAllProducts() throws Exception {
               Pageable limit = PageRequest.of(0, 100);
                List<Products> products=productRepo.findAll(limit).getContent();
                if(products.isEmpty()){
                    System.out.println("No products found");
                }
                return products;
    }

    @Override
    public Optional<Products> getProductById(Long id) throws Exception {
        return productRepo.findById(id);
    }
}
