package com.cg.mts.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BinValidationException {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> 
			errors.put(error.getField(), error.getDefaultMessage()));
		
		return errors;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		
		ex.getConstraintViolations().forEach(cv -> {
			errors.put("message", cv.getMessage());
			errors.put("path", (cv.getPropertyPath()).toString());
		});	

		return errors;
	}	

}
