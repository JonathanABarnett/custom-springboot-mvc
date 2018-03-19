package com.alaythiaproductions.customspringbootmvc.controllers;

import com.alaythiaproductions.customspringbootmvc.models.Employee;
import com.alaythiaproductions.customspringbootmvc.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(value = "/listOfSkills")
    public String listOfSkills(Model model, @RequestParam(defaultValue = "") Employee employee) {
        model.addAttribute("title", "List of Skills");
        model.addAttribute("skills", skillService.findEmployeeSkills(employee));

        return "views/listOfSkills";
    }
}
