package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UserService;


@Controller
public class UserController {
        private UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String HomePage(Model model){
        UserService test = new UserService();
        model.addAttribute("message", test.handleHello());
        return "hello";
    }
    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping(value="/admin/user/create1",method=RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser")User newUser){
        System.out.println("run here"+ newUser);
        return "hello";
    }
}