package com.nisum.bci.user.manager.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserException extends RuntimeException{

    private String message;

    public UserException(String message){

        super(message);
        this.message = message;
    }
}
