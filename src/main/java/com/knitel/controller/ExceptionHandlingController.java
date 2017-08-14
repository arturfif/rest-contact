package com.knitel.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(BadRequestException.class)
    public HttpEntity<?> handleBadRequest() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
