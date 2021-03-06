package com.alaythiaproductions.customspringbootmvc.controllers;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.services.DepartmentService;
import com.alaythiaproductions.customspringbootmvc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/listOfEmployees")
    public String listOfEmployees(Model model, @RequestParam(defaultValue = "") String name) {
        model.addAttribute("heading", "List of Employees");
        model.addAttribute("title", "List of Employees");
        model.addAttribute("employees", employeeService.findByLastNameLike(name));


        return "views/listOfEmployees";
    }
}
