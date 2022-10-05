package com.nisum.bci.user.manager.controller;

import com.nisum.bci.user.manager.controller.model.UserRequest;
import com.nisum.bci.user.manager.controller.model.UserResponse;
import com.nisum.bci.user.manager.controller.validator.UserValidator;
import com.nisum.bci.user.manager.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @SneakyThrows
    @PostMapping(path = "/createUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){

        return ResponseEntity
                .ok()
                .body(userService.saveUser(userRequest));
    }

}
