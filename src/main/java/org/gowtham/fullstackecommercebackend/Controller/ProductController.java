package org.gowtham.fullstackecommercebackend.Controller;

import org.gowtham.fullstackecommercebackend.DTO.ErrorResponse;
import org.gowtham.fullstackecommercebackend.Model.Products;
import org.gowtham.fullstackecommercebackend.Services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/api/products")
    public ResponseEntity<?>getAllProducts() throws Exception {
        List<Products> allProducts=productService.getAllProducts();
        if(allProducts.isEmpty()){
            ErrorResponse errorResponse=new ErrorResponse();
            errorResponse.setStatus(HttpStatus.BAD_REQUEST);
            errorResponse.setMessage("No products found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);

    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) throws Exception {
        Optional<Products> products=productService.getProductById(id);


        if(products.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(products.get());
        }
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        errorResponse.setMessage("Product not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
