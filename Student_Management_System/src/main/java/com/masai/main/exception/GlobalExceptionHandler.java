package com.masai.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> AddressExceptionHandler(StudentException e, WebRequest re)
	{
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setHttpstatus(HttpStatus.BAD_REQUEST);
		err.setDetails(re.getDescription(false));
	
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}

}
