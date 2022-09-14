package com.zee.zee5app.advice;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zee.zee5app.exceptions.InvalidEmainException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;
import com.zee.zee5app.exceptions.UsernameExistsExecption;
import com.zee.zee5app.exceptions.apierror.ApiError;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ExceptionAdvice  extends ResponseEntityExceptionHandler{
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
	
	
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
//		return super.handleMethodArgumentNotValid(ex, headers, status, request);
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation Error");
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors()); // fieldwise errors
//		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	private ResponseEntity<Object> buildResponseEntity(ApiError	apiError){
		// to get which RE object === > if I wnat to make any changes into our existing object then in every return we have to do the change 
		// instead of that if we will use buildRE method ===> EOM.
		return new ResponseEntity<>(apiError,apiError.getHttpStatus());
	} 
	
}
