package com.xroneteach.spring_ecom.service.serviceImpl;

import com.xroneteach.spring_ecom.dto.UserLoginInRequestDTO;
import com.xroneteach.spring_ecom.dto.UserRegisterRequestDto;
import com.xroneteach.spring_ecom.model.User;
import com.xroneteach.spring_ecom.repository.UserRepository;
import com.xroneteach.spring_ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> userSignUp(UserRegisterRequestDto userRegisterRequestDto) {
        if (userRegisterRequestDto.getFirstName().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("First Name not found");
        }else if (userRegisterRequestDto.getLastName().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Last Name not found");
        }else if (userRegisterRequestDto.getEmail().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }else if (!Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?^`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])*$").matcher(userRegisterRequestDto.getEmail()).matches()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Email Address");
        } else if (userRegisterRequestDto.getMobile().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mobile not found");
        }else if (!Pattern.compile("^07[01245678][0-9]{7}$").matcher(userRegisterRequestDto.getMobile()).matches()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Mobile Number");
        }
//        else if (){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid password");
//
//        }
        else if (userRegisterRequestDto.getPassword().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("password not found");
        } else if (userRepository.findByEmail(userRegisterRequestDto.getEmail().toLowerCase()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email Already Exist");
        }else if (userRepository.findByMobile(userRegisterRequestDto.getMobile()).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mobile Already Exist");
        }else {
            User user = new User();
            user.setFirstName(userRegisterRequestDto.getFirstName());
            user.setLastName(userRegisterRequestDto.getLastName());
            user.setEmail(userRegisterRequestDto.getEmail().toLowerCase());
            user.setMobile(userRegisterRequestDto.getMobile());
            user.setPassword(userRegisterRequestDto.getPassword());
//            user.setUserType(userRegisterRequestDto.getUserType());

            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("account created successful!");
        }
    }

    @Override
    public ResponseEntity<?> userLogIn(UserLoginInRequestDTO userLoginInRequestDTO) {
        if (userLoginInRequestDTO.getEmail().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not Found");
        }else if (userLoginInRequestDTO.getPassword().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password not Found");
        }else if (userRepository.findByEmailAndPassword(userLoginInRequestDTO.getEmail(), userLoginInRequestDTO.getPassword()).isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
        }else  {
            return  ResponseEntity.status(HttpStatus.OK).body("User Logged Successfully");
        }
    }


}
