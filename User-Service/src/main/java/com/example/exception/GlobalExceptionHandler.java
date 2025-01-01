package com.example.exception;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		String errMsg = ex.getFieldErrors().stream()
						.map(err-> err.getField()+" :"+err.getDefaultMessage())
						.reduce((a,b)->a+"\n"+b).get();

		return new ResponseEntity<>(errMsg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handlerException(Exception ex){
		ex.getStackTrace();
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
 