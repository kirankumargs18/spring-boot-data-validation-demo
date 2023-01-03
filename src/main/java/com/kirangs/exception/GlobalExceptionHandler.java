package com.kirangs.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException exception) {

		Map<String, String> errorMap = new HashMap<>();

		exception.getBindingResult().getFieldErrors().forEach(error -> {

			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleBusinessException(UserNotFoundException exception) {

		Map<String, String> errorMap = new HashMap<>();

		errorMap.put("message", exception.getMessage());
		
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.NOT_FOUND);
	}
	

}
