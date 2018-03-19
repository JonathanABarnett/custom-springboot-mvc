package com.alaythiaproductions.customspringbootmvc.controllers;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "")
    public String indexPage(Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("home_page", "A Random Website");
        return "views/index";
    }
}
