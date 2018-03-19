package com.alaythiaproductions.customspringbootmvc.services;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.models.Skill;
import com.alaythiaproductions.customspringbootmvc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        employee.setPassword(encoder.encode(employee.getPassword()));
        employeeRepository.save(employee);
    }

    public Employee findOne(long id) {
        return employeeRepository.findOne(id);
    }

    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public boolean employeeAlreadyExsists(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            return true;
        }
        return false;
    }


}
