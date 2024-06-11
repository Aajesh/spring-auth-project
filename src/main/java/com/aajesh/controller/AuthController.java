package com.aajesh.controller;

import com.aajesh.model.LoginRequest;
import com.aajesh.model.UserModel;
import com.aajesh.model.UserResponse;
import com.aajesh.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
   UserModelService userModelService;
    @GetMapping
    public String Test() {
        return "Aajesh choudhary";
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@RequestBody UserModel userModel){
        return  userModelService.signUp(userModel);

    }

//    @PostMapping("/login")
//    public String login(@RequestBody UserModel userModel){
//        return userModelService.login(userModel.getEmail(), userModel.getPassword());
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String result = userModelService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (result.equals("Successful login")) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
    }
}