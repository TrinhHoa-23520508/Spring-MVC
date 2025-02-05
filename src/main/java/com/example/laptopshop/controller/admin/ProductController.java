package com.example.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UploadFileService;
import com.example.laptopshop.domain.Product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public String postCreateProduct(Model model, @ModelAttribute("newProduct") Product newProduct, @RequestParam("productFile") MultipartFile file){
        
        String imgProduct = this.uploadFileService.handleUploadFile(file, "product");
        newProduct.setImage(imgProduct);
        this.productService.handleSaveProduct(newProduct);
        return "redirect:/admin/product";
    }
    
    
}
