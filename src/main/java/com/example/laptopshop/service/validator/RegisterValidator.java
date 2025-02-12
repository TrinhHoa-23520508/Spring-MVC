package com.example.laptopshop.service.validator;

import org.springframework.stereotype.Service;

import com.example.laptopshop.domain.dto.RegisterDTO;
import com.example.laptopshop.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO>{

    private final UserService userService;
    public RegisterValidator(UserService userService)
    {
        this.userService = userService;
    }
    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context)
    {
        boolean valid = true;
        //check password must match confirmPassword
        if(!user.getPassword().equals(user.getConfirmPassword()))
        {
            context.buildConstraintViolationWithTemplate("Password và confirmPassword không khớp!")  
                   .addPropertyNode("confirmPassword")
                   .addConstraintViolation()
                   .disableDefaultConstraintViolation();
            valid = false;

        }
        //check email has exists
        if(this.userService.checkExistEmail(user.getEmail()))
        {
            context.buildConstraintViolationWithTemplate("Email đã tồn tại!")  
            .addPropertyNode("email")
            .addConstraintViolation()
            .disableDefaultConstraintViolation();
            valid = false;
        }
        return valid;
    }
}
