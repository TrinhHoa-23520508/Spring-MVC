package com.example.laptopshop.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {
        private final UserService userService;
     
    public UserController(UserService userService ){ 
        this.userService = userService;
    }

    @RequestMapping("/")
    public String HomePage(Model model){
      
        List<User> users = this.userService.getAllUsersByEmail("trinhhoa.gl2005@gmail.com");
        return "hello";
    }
    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }
    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping("/admin/user/{id}")
    public String getCreateUserPage(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }
    @RequestMapping(value="/admin/user/create",method=RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser")User newUser){
        System.out.println("run here"+ newUser);
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }
    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }
    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("user")User updateUser){
        User currentUser = this.userService.getUserById(updateUser.getId());
        if(updateUser!=null){
            currentUser.setFullName(updateUser.getFullName());  
            currentUser.setPhone(updateUser.getPhone());
            currentUser.setAddress(updateUser.getAddress());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }
    @RequestMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id){
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/delete";
    }
    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("user")User deleteUser){
        User currentUser = this.userService.getUserById(deleteUser.getId());
        if(deleteUser!=null){
            this.userService.handleDeleteUser(currentUser.getId());
        }
        return "redirect:/admin/user";
    }
}