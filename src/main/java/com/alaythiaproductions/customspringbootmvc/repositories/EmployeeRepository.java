package com.alaythiaproductions.customspringbootmvc.repositories;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByFirstName(String firstName);

    public List<Employee> findByLastName(String lastName);

    public Employee findByEmail(String email);
}
