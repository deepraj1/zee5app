package com.zee.zee5app.advice;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(UsernameExistsExecption.class)	// to handle the global level exception 
	public ResponseEntity<?> recordExistsExceptionHandler(UsernameExistsExecption e){
		HashMap<String	, String> resData = new HashMap<>();
		resData.put("status", "username already exists");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(resData);
		
	}
	@ExceptionHandler(UNableToGenerateIdException.class)
	public ResponseEntity<?> UNableToGenerateIdException(UsernameExistsExecption e){
		HashMap<String	, String> resData = new HashMap<>();
		resData.put("status", "id generation problem");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resData);
		
	}
	@ExceptionHandler(InvalidEmainException.class)
	public ResponseEntity<?> InvalidEmainException(UsernameExistsExecption e){
		HashMap<String	, String> resData = new HashMap<>();
		resData.put("status", "email already exists");
		return ResponseEntity.status(HttpStatus.CONFLICT).body(resData);
		
	}
	
//	@ExceptionHandler(FileNotFoundException.class)
//	public ResponseEntity<?> FileNotFoundException11(FileNotFoundException e){
//		HashMap<String	, String> resData = new HashMap<>();
//		resData.put("status", "email already exists");
//		return ResponseEntity.status(HttpStatus.CONFLICT).body(resData);
//		
//	}
	
}
