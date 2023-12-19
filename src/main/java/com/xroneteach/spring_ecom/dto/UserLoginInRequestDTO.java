package com.xroneteach.spring_ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginInRequestDTO {
    private String email;
    private String password;
}
