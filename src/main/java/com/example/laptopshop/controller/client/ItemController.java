package com.example.laptopshop.controller.client;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.laptopshop.domain.CartDetail;
import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class ItemController {
    private final ProductService productService;
    private final UserService userService;

    public ItemController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/product/{id}")
    public String getMethodName(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }
    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request)
    {
        //get session
        HttpSession session = request.getSession();
        long user_id = (long) session.getAttribute("id");
        User user = this.userService.getUserById(user_id);
        this.productService.handleAddProductToCart(id, user, session);
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String getCartPage(Model model , HttpServletRequest request){
        //get session
        HttpSession session = request.getSession();
        long user_id = (long) session.getAttribute("id");
        User user = this.userService.getUserById(user_id);
        List<CartDetail> cartDetails = this.productService.getAllCartDetails(user);
        double totalPrice = 0;
        for(CartDetail cartDetail : cartDetails){
              totalPrice += cartDetail.getPrice()*cartDetail.getQuantity();
        }
        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        return "client/cart/show";
    }
    

}
