package com.example.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UploadFileService;

import jakarta.validation.Valid;

import com.example.laptopshop.domain.Product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadFileService uploadFileService;
    public ProductController(ProductService productService, UploadFileService uploadFileService){
        this.productService = productService;
        this.uploadFileService = uploadFileService;
    }
    @GetMapping("/admin/product")
    public String getProductPage(Model model){
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "admin/product/show";
    }
    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }
    @PostMapping("/admin/product/create")
    public String postCreateProduct(
        Model model, 
        @ModelAttribute("newProduct") @Valid Product newProduct, 
        BindingResult newProductBindingResult,
        @RequestParam("productFile") MultipartFile file
        ){
         if (newProductBindingResult.hasErrors()) {
            List<FieldError> errors = newProductBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField() + " - " + error.getDefaultMessage());
            }
            return "admin/product/create";
        }
        String imgProduct = this.uploadFileService.handleUploadFile(file, "product");
        newProduct.setImage(imgProduct);
        this.productService.handleSaveProduct(newProduct);
        return "redirect:/admin/product";
    }
    @RequestMapping("/admin/product/{id}")
    public String getViewProductPage(@PathVariable long id, Model model){
         Product product = this.productService.getProductBydId(id);
         model.addAttribute("product", product);
         return "admin/product/detail";
    }
    
    
}
