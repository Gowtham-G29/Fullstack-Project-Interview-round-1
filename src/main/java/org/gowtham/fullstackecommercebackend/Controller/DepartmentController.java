package org.gowtham.fullstackecommercebackend.Controller;

import org.gowtham.fullstackecommercebackend.DTO.ErrorResponse;
import org.gowtham.fullstackecommercebackend.Model.Departments;
import org.gowtham.fullstackecommercebackend.Services.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    @GetMapping("/api/departments")
    public ResponseEntity<?>getAllDepartments() {

        List<Departments> departments = departmentService.getAllDepartments();
        if (departments.isEmpty()) {
            ErrorResponse  errorResponse = new ErrorResponse();
            errorResponse.setMessage("No departments found");
            errorResponse.setStatus(HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(departments);


    }

    @GetMapping("/api/departments/{id}")
    public ResponseEntity<?> getSpecficDept(@PathVariable long id) {
        Optional<Departments>departments=departmentServiceImpl.getDepartmentById(id);
        if (departments.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(departments);
        }
        ErrorResponse  errorResponse = new ErrorResponse();
        errorResponse.setMessage("No departments found");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @GetMapping("/api/departments/{id}/products")
    public ResponseEntity<?>getDepartmentProduct(@PathVariable long id) {
        Optional<Departments>departments=departmentServiceImpl.getDepartmentById(id);
        if (departments.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(departments.get().getProducts());
        }
        ErrorResponse  errorResponse = new ErrorResponse();
        errorResponse.setMessage("No departments found");
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
