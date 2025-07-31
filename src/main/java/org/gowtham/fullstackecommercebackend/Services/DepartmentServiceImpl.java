package org.gowtham.fullstackecommercebackend.Services;

import org.gowtham.fullstackecommercebackend.Model.Departments;
import org.gowtham.fullstackecommercebackend.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public List<Departments> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Departments> getDepartmentById(long id) {
        return departmentRepo.findById(id);
    }
}
