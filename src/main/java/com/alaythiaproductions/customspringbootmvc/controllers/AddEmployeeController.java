package com.alaythiaproductions.customspringbootmvc.controllers;

import com.alaythiaproductions.customspringbootmvc.models.Department;
import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.services.DepartmentService;
import com.alaythiaproductions.customspringbootmvc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AddEmployeeController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/addEmployee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("title", "New Employee");
        model.addAttribute("heading", "Register a new Employee");
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute(new Employee());
        return "views/addEmployee";
    }

    @PostMapping(value = "/addEmployee")
    public String processAddEmployeeForm(Model model, @ModelAttribute @Valid Employee employee, @RequestParam int departmentId, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "New Employee");
            model.addAttribute("heading", "Register a new Employee");
            model.addAttribute("departments", departmentService.findAll());
            return "views/addEmployee";
        }

        if (employeeService.employeeAlreadyExsists(employee.getEmail())) {
            model.addAttribute("exists", true);
            model.addAttribute("title", "New Employee");
            model.addAttribute("heading", "Register a new Employee");
            model.addAttribute("departments", departmentService.findAll());
            return "views/addEmployee";
        }

        Department department = departmentService.findById(departmentId);
        employee.setDepartment(department);
        employeeService.createEmployee(employee);
        return "views/success";
    }
}
