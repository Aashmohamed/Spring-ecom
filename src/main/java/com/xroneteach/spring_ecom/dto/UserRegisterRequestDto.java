package com.xroneteach.spring_ecom.dto;

import com.xroneteach.spring_ecom.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
//    private UserType userType;
}