package com.wipro.springboot.fandemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 
 * @author binu
 *FanRestExceptionHandler class catches the  customized exception 
 *as well as any unknown exceptions
 */

@ControllerAdvice
public class FanRestExceptionHandler {

	
	/**
	 * Handling Customized Exception FanSettingNotFoundException
	 * @param ex
	 * @return ResponseEntity
	 */
	@ExceptionHandler
	public ResponseEntity<FanErrorResponse> handleFanNotFoundException(FanSettingNotFoundException ex){
		
		FanErrorResponse error=new FanErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handling Unknown Exceptions
	 * @param ex
	 * @return ResponseEntity
	 */
	  @ExceptionHandler 
	  public ResponseEntity<FanErrorResponse> handleExceptions(Exception ex){
	  
	  FanErrorResponse error=new FanErrorResponse();
	  
	  error.setStatus(HttpStatus.BAD_REQUEST.value());
	  error.setMessage(ex.getMessage());
	  error.setTimeStamp(System.currentTimeMillis());
	  return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); 
	  
	  }
	 
	 
	 
}
