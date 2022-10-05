package com.nisum.bci.user.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<ErrorModel> handleUserException(RuntimeException exception, WebRequest request){
        ErrorModel errorModel = ErrorModel.builder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity(errorModel, HttpStatus.FORBIDDEN);

    }

}
