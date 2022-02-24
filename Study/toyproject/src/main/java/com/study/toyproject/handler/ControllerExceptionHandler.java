package com.study.toyproject.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.study.toyproject.handler.ex.CustomException;

import com.study.toyproject.util.Script;


@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public String exception(RuntimeException e) {
		return Script.back(e.getMessage());	
	}


}
