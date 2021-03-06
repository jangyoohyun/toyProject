package com.study.toyproject.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.util.Script;
import com.study.toyproject.web.dto.ExceptionResponse;


@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String exception(RuntimeException e) {
		return Script.back(e.getMessage());
	}
	
	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<?> validException(MethodArgumentNotValidException
	 * validException) {
	 * 
	 * ExceptionResponse exceptionResponse = new
	 * ExceptionResponse("validation failed",
	 * validException.getBindingResult().toString());
	 * 
	 * return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */

}
