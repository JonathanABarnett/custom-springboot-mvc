package com.alaythiaproductions.customspringbootmvc.services;

import com.alaythiaproductions.customspringbootmvc.models.Department;
import com.alaythiaproductions.customspringbootmvc.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(int id) {
        return departmentRepository.getOne(id);
    }
}
