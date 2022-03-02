package com.study.toyproject.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.util.Script;


@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String exception(RuntimeException e) {
		return Script.back(e.getMessage());
	}
	
	
	  @ExceptionHandler(MethodArgumentNotValidException.class) 
	  public ResponseEntity<?> validException(MethodArgumentNotValidException validException) {
	  
	  BindingResult bindingResult = validException.getBindingResult();
	  
	  StringBuilder builder = new StringBuilder(); 
	  for(FieldError error : bindingResult.getFieldErrors()) { 
		  builder.append(error.getDefaultMessage());
	  }
	  
		return new ResponseEntity<>(builder.toString(), HttpStatus.BAD_REQUEST);
	  
	  }
	 


}
