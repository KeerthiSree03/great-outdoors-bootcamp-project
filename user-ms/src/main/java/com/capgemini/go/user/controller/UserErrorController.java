package com.capgemini.go.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.user.exceptions.NotFoundException;
import com.capgemini.go.user.exceptions.InvalidInputException;
import com.capgemini.go.user.exceptions.UserAlreadyExistsException;

@RestController
@ControllerAdvice
public class UserErrorController {
	
	@ExceptionHandler({InvalidInputException.class, UserAlreadyExistsException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "INVALID INPUT", code = HttpStatus.NOT_FOUND)
	public void handleInvalidInputExceptions() {
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "DATA DOES NOT EXIST", code = HttpStatus.NOT_FOUND)
	public void handleUserNotFoundException() {
		
	}
	
	

}
