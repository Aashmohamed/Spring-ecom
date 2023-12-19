package com.xroneteach.spring_ecom.service;

import com.xroneteach.spring_ecom.dto.UserLoginInRequestDTO;
import com.xroneteach.spring_ecom.dto.UserRegisterRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<?> userSignUp(UserRegisterRequestDto userRegisterRequestDto);

    ResponseEntity<?> userLogIn(UserLoginInRequestDTO userLoginInRequestDTO);
}
