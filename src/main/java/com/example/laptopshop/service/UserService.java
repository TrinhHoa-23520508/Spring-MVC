package com.example.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.Role;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.RoleRepository;
import com.example.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
    public Role getRoleByName(String name)
    {
        return this.roleRepository.getRoleByName(name);
    }
}
