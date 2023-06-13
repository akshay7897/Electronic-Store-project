package com.ap.electronic.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ap.electronic.dtos.ApiResponse;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

		ApiResponse response = ApiResponse.builder().message(ex.getMessage()).success(true).build();

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {

		List<ObjectError> objectErr = ex.getBindingResult().getAllErrors();
		Map<String, Object> map = new HashMap<>();

		objectErr.stream().forEach(e -> {
			String message = e.getDefaultMessage();
			String field = ((FieldError) e).getField();
			map.put(field, message);
		});
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}

}
