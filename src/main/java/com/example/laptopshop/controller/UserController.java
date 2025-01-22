package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.UserRepository;
import com.example.laptopshop.service.UserService;


@Controller
public class UserController {
        private final UserService userService;
     
    public UserController(UserService userService ){ 
        this.userService = userService;
    }

    @RequestMapping("/")
    public String HomePage(Model model){
      
        
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
        this.userService.handleSaveUser(newUser);
        return "hello";
    }
}