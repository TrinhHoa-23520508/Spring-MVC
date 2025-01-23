package com.example.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    public List<User> getAllUsersByEmail(String email){
        return this.userRepository.findByEmail(email);
    }
    public User handleSaveUser(User newUser) {
        User eric = this.userRepository.save(newUser);
        return eric;
    }
    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }
    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }
}
