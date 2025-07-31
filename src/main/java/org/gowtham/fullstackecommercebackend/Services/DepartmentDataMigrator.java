package org.gowtham.fullstackecommercebackend.Services;

import org.gowtham.fullstackecommercebackend.Model.Departments;
import org.gowtham.fullstackecommercebackend.Model.Products;
import org.gowtham.fullstackecommercebackend.Repository.DepartmentRepo;
import org.gowtham.fullstackecommercebackend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class DepartmentDataMigrator implements CommandLineRunner {

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private DepartmentRepo departmentRepository;

    @Override
    public void run(String... args) {
        List<Products> products = productRepository.findAll();

        Map<String, List<Products>> deptProductMap = products.stream()
                .filter(p -> p.getDepartment() != null && !p.getDepartment().trim().isEmpty())
                .collect(Collectors.groupingBy(p -> p.getDepartment().trim()));

        for (Map.Entry<String, List<Products>> entry : deptProductMap.entrySet()) {
            String deptName = entry.getKey();
            List<Products> deptProducts = entry.getValue();

            Departments department = departmentRepository.findByName(deptName)
                    .orElseGet(() -> departmentRepository.save(new Departments(null, deptName, null)));

            for (Products product : deptProducts) {
                product.setDepartments(department);
            }

            productRepository.saveAll(deptProducts);
        }

        System.out.println("Departments and product associations updated successfully.");
    }
}
