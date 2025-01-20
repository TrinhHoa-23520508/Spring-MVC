package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
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
    public String HomePage(){
        UserService test = new UserService();
        return "hello";
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