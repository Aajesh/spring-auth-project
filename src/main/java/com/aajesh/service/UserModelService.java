package com.aajesh.service;

import com.aajesh.model.UserModel;
import com.aajesh.model.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserModelService {
    ResponseEntity<UserResponse> signUp(UserModel userModel);
    String login(String email, String password);
}
