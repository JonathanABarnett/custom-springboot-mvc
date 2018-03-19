package com.alaythiaproductions.customspringbootmvc.controllers;

import com.alaythiaproductions.customspringbootmvc.models.Skill;
import com.alaythiaproductions.customspringbootmvc.services.EmployeeService;
import com.alaythiaproductions.customspringbootmvc.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AddSkillController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    @GetMapping(value = "/addSkill")
    public String addSkillForm(Model model, int id, HttpSession session) {

        session.setAttribute("id", id);

        model.addAttribute("title", "Add Skill");
        model.addAttribute("heading", "Add a New Skill");
        model.addAttribute("skill", new Skill());

        return "views/addSkill";

    }

    @PostMapping(value = "/addSkill")
    public String processAddStringForm(@Valid @ModelAttribute Skill skill, Errors errors, HttpSession session, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Skill");
            return "views/addSkill";
        }

        int id = (Integer) session.getAttribute("id");
        skillService.addSkill(skill, employeeService.findOne(id));

        return "redirect:/listOfEmployees";

    }
}
