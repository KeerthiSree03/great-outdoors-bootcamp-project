package com.capgemini.go.deliverytimereports.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.deliverytimereports.exceptions.NotFoundException;

@RestController
@ControllerAdvice
public class DeliveryTimeReportsErrorController {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "DATA DOES NOT EXIST", code = HttpStatus.NOT_FOUND)
	public void handleUserNotFoundException() {
		
	}

}
