package com.alaythiaproductions.customspringbootmvc.controllers;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.services.EmployeeService;
import com.alaythiaproductions.customspringbootmvc.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/listOfSkills")
    public String listOfSkills(Model model, int id, String firstName, HttpSession session) {
        session.setAttribute("id", id);
        model.addAttribute("name", employeeService.findOne(id).getFirstName() + "'s Skills");
        model.addAttribute("title", "List of Skills");
        model.addAttribute("skills", skillService.findByEmployeeId(id));

        return "views/listOfSkills";
    }

    @GetMapping(value = "/allSkills")
    public String listAllSkills(Model model) {
        model.addAttribute("title", "All Skills");
        model.addAttribute("header", "List of All Skills");
        model.addAttribute("skills", skillService.findAll());
        return "views/allSkills";
    }
}
