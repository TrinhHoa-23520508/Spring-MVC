package com.example.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.Cart;
import com.example.laptopshop.domain.CartDetail;
import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.CartDetailRepository;
import com.example.laptopshop.repository.CartRepository;
import com.example.laptopshop.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    public ProductService(ProductRepository productRepository, CartRepository cartRepository, CartDetailRepository cartDetailRepository){
        this.productRepository = productRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
    }
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
    public Product getProductById(long id){
        return this.productRepository.findById(id);
    }
    public Product handleSaveProduct(Product newProduct){
        return this.productRepository.save(newProduct);
    }
    public void handleDeleteProduct(long id){
        this.productRepository.deleteById(id);
    }
    public void handleAddProductToCart(long product_id, User user, HttpSession session) {
        if (user == null) {
            return;
        }
    
      
        Cart cart = this.cartRepository.findCartByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            //temp
            cart.setSum(0);
            this.cartRepository.save(cart); 
        }
       
    
  
        Product product = this.getProductById(product_id);
        if (product == null) {
            return; 
        }
    

        CartDetail cartDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);
        if (cartDetail == null) {
          
            cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setProduct(product);
            cartDetail.setQuantity(1);
            cartDetail.setPrice(product.getPrice());
            cart.setSum(cart.getSum()+1 );
            session.setAttribute("sum", cart.getSum());
        } else {
         
            cartDetail.setQuantity(cartDetail.getQuantity() + 1);
            cartDetail.setPrice(cartDetail.getPrice() + product.getPrice());
        }
   
        this.cartDetailRepository.save(cartDetail);
       
      
        
        this.cartRepository.save(cart);
    }
    
    
}
