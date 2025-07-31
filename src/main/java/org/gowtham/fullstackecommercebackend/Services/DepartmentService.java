package org.gowtham.fullstackecommercebackend.Services;

import org.gowtham.fullstackecommercebackend.Model.Departments;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Departments>getAllDepartments();
    Optional<Departments> getDepartmentById(long id);
}
