package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String UserPage(Model model){
        
        return "admin/user/create";
    }
}
// @RestController
// public class UserController {
//     private UserService userService;
    
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @RequestMapping("/")
//     public String HomePage(){
//         return this.userService.handleHello();
//     }
// }