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

    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("title", "New Employee");
        model.addAttribute("heading", "Register a new Employee");
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("employee", new Employee());
        return "views/addEmployee";
    }

    @PostMapping("/addEmployee")
    public String processAddEmployeeForm(@Valid @ModelAttribute Employee employee, @RequestParam int departmentId, Model model, Errors errors) {
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
        model.addAttribute("title", "Success!");
        model.addAttribute("success", "Success in adding new Employee!");
        return "views/success";
    }
}
