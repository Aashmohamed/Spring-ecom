package com.xroneteach.spring_ecom.controller;


import com.xroneteach.spring_ecom.dto.UserLoginInRequestDTO;
import com.xroneteach.spring_ecom.dto.UserRegisterRequestDto;
import com.xroneteach.spring_ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public ResponseEntity<?> userSigUp(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return userService.userSignUp(userRegisterRequestDto);

    }
    @PostMapping("/login")
    public  ResponseEntity<?>userLogIn(@RequestBody UserLoginInRequestDTO userLoginInRequestDTO) {
        return userService.userLogIn(userLoginInRequestDTO);
    }
}