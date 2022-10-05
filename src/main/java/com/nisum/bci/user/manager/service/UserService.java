package com.nisum.bci.user.manager.service;

import com.google.gson.Gson;
import com.nisum.bci.user.manager.controller.model.UserRequest;
import com.nisum.bci.user.manager.controller.model.UserResponse;
import com.nisum.bci.user.manager.controller.validator.UserValidator;
import com.nisum.bci.user.manager.dao.UserDao;
import com.nisum.bci.user.manager.exception.UserException;
import com.nisum.bci.user.manager.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Value("${regex.email}")
    private String emailRegex;

    @Value(("${regex.password}"))
    private String passwordRegex;

    public UserResponse saveUser(UserRequest userRequest){

        UserValidator.validateUserRequest(userRequest, emailRegex, passwordRegex);

        if(userRepository.findByEmail(userRequest.getEmail()) != null){

            throw new UserException("El correo ya está registrado", HttpStatus.FORBIDDEN);
        }

        UserDao userDao = UserDao.builder()
                .userId(UUID.randomUUID().toString())
                .created(Instant.now().toString())
                .password(Base64.getEncoder().encodeToString(userRequest.getPassword().getBytes()))
                .email(userRequest.getEmail())
                .isActive("true")
                .lastLogin(Instant.now().toString())
                .modified(Instant.now().toString())
                .name(userRequest.getName())
                .phones(new Gson().toJson(userRequest.getPhones()))
                .token(UUID.randomUUID().toString())
                .build();

        userRepository.save(userDao);

        return UserResponse.builder()
                .userId(userDao.getUserId())
                .created(userDao.getCreated())
                .modified(userDao.getModified())
                .lastLogin(userDao.getLastLogin())
                .token(userDao.getToken())
                .isActive(userDao.getIsActive())
                .build();
    }
}
