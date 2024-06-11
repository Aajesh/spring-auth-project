package com.aajesh.service;

import com.aajesh.model.UserModel;
import com.aajesh.model.UserResponse;
import com.aajesh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserModelServiceImpl implements UserModelService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> signUp(UserModel userModel) {
        // Check if email already exists in the database
        if (userRepository.findByEmail(userModel.getEmail()) != null) {
            // Email already exists, do not insert
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new UserResponse(false, "Email already exists"));
        } else {
            // check all the required fields here
//            name should be string, min=3, max=100
//            email should be a valid email
//            password alpha numeric (a-b,0-9) min=3 max=100
//            if all the checked are passed than save otherwise send back 400 to client
            userRepository.save(userModel); // Insert the user into the database
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new UserResponse(true, "User saved successfully"));
        }
    }


    @Override
    public String login(String email, String password) {

        UserModel user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            return "Successful login";
        } else {
            return "Invalid email or password";
        }
    }
}
