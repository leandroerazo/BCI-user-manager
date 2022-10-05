package com.nisum.bci.user.manager.controller.validator;

import com.nisum.bci.user.manager.controller.model.UserRequest;
import com.nisum.bci.user.manager.exception.UserException;
import org.springframework.beans.factory.annotation.Value;

import java.util.regex.Pattern;

public class UserValidator {

    private UserValidator(){
    }

    public static void validateUserRequest(UserRequest request, String emailRegex, String passwordRegex){

        Boolean fitsEmailRegex = Pattern.compile(emailRegex)
                .matcher(request.getEmail())
                .matches();

        if (!fitsEmailRegex){
            throw new UserException("El email debe seguir la expresión regular " + emailRegex);
        }


        Boolean fitsPasswordRegex = Pattern.compile(passwordRegex)
                .matcher(request.getPassword())
                .matches();

        if (!fitsPasswordRegex){
            throw new UserException("El password debe seguir la expresión regular " + passwordRegex);
        }

    }

}
