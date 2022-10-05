package com.nisum.bci.user.manager.controller.validator;

import com.nisum.bci.user.manager.controller.model.UserRequest;
import com.nisum.bci.user.manager.exception.UserException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

public class UserValidator {

    private UserValidator(){
    }

    public static void validateUserRequest(UserRequest request, String emailRegex, String passwordRegex){

        if(request.getName() == null){
            throw new UserException("Debe agregar un nombre", HttpStatus.BAD_REQUEST);
        }

        if(request.getName().isEmpty()){
            throw new UserException("El nombre no puede estar vacío", HttpStatus.BAD_REQUEST);
        }

        Boolean fitsEmailRegex = Pattern.compile(emailRegex)
                .matcher(request.getEmail())
                .matches();

        if (!fitsEmailRegex){
            throw new UserException("El email debe seguir la expresión regular " + emailRegex, HttpStatus.BAD_REQUEST);
        }


        Boolean fitsPasswordRegex = Pattern.compile(passwordRegex)
                .matcher(request.getPassword())
                .matches();

        if (!fitsPasswordRegex){
            throw new UserException("El password debe seguir la expresión regular " + passwordRegex, HttpStatus.BAD_REQUEST);
        }

    }

}
