package com.example.laptopshop.controller.client;

import java.util.List;

import com.example.laptopshop.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.dto.RegisterDTO;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
public class HomePageController {
    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    public HomePageController(ProductService productService, UserService userService, PasswordEncoder passwordEncoder){
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") RegisterDTO registerUser, Model model) {
        User user = this.userService.registerDTOtoUser(registerUser);
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));
        this.userService.handleSaveUser(user);
        
        return "redirect:/login" ;
    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginUser", new RegisterDTO());
        return "client/auth/login";
    }
    
    
}
