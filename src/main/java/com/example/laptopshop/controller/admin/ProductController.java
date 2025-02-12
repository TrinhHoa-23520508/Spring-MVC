package com.example.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
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
         Product product = this.productService.getProductById(id);
         model.addAttribute("product", product);
         return "admin/product/detail";
    }
    @RequestMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(@PathVariable long id, Model model)
    {
        Product product = this.productService.getProductById(id);
        model.addAttribute("updateProduct", product);
        return "admin/product/update";

    }
    @PostMapping("/admin/product/update")
    public String postUpdateProduct(
        Model model, 
        @ModelAttribute("updateProduct") @Valid Product updateProduct, 
        BindingResult updateProductBindingResult,
        @RequestParam("productFile") MultipartFile file
        ){
            if(updateProductBindingResult.hasErrors())
            {
                List<FieldError> errors = updateProductBindingResult.getFieldErrors();
                for(FieldError error : errors )
                {
                    System.out.println(error.getField() + " - " + error.getDefaultMessage());
                }
                return "admin/product/update";
            }
            Product product = this.productService.getProductById(updateProduct.getId());
            if(!file.isEmpty())
            {
                String image = this.uploadFileService.handleUploadFile(file, "product");
                product.setImage(image);
            }
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setDetailDesc(updateProduct.getDetailDesc());
            product.setShortDesc(updateProduct.getShortDesc());
            product.setQuantity(updateProduct.getQuantity());
            product.setFactory(updateProduct.getFactory()); 
            product.setTarget(updateProduct.getTarget());
            this.productService.handleSaveProduct(product);
            return "redirect:/admin/product";

        }
    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) 
    {
        Product deleteProduct = this.productService.getProductById(id);
        model.addAttribute("deleteProduct", deleteProduct);
        return "admin/product/delete";
    }
    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("deleteProduct") Product deleteProduct)
    {
       Product currentProduct = this.productService.getProductById(deleteProduct.getId());
       if(deleteProduct!=null)
       {
           this.productService.handleDeleteProduct(currentProduct.getId());
       }
       return "admin/product/show";

    }
    
    
}
