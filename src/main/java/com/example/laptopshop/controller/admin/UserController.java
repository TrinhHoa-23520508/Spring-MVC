package com.example.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import com.example.laptopshop.service.UploadFileService;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadFileService uploadFileService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadFileService uploadFileService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadFileService = uploadFileService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/{id}")
    public String getViewUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @PostMapping("/admin/user/create")
    public String postCreateUser(Model model,
            @ModelAttribute("newUser") @Valid User newUser,
            BindingResult newUserBindingResult,
            @RequestParam("avatarFile") MultipartFile file) {
        if (newUserBindingResult.hasErrors()) {
            List<FieldError> errors = newUserBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField() + " - " + error.getDefaultMessage());
            }
            return "admin/user/create";
        }
        String avatar = this.uploadFileService.handleUploadFile(file, "avatar");
        if (avatar.equals("")) {
            avatar = "default-avatar.jpg";
        }
        String hashPassword = this.passwordEncoder.encode(newUser.getPassword());
        newUser.setRole(this.userService.getRoleByName(newUser.getRole().getName()));
        newUser.setAvatar(avatar);
        newUser.setPassword(hashPassword);
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("user") User updateUser) {
        User currentUser = this.userService.getUserById(updateUser.getId());
        if (updateUser != null) {
            currentUser.setFullName(updateUser.getFullName());
            currentUser.setPhone(updateUser.getPhone());
            currentUser.setAddress(updateUser.getAddress());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("user") User deleteUser) {
        User currentUser = this.userService.getUserById(deleteUser.getId());
        if (deleteUser != null) {
            this.userService.handleDeleteUser(currentUser.getId());
        }
        return "redirect:/admin/user";
    }
}