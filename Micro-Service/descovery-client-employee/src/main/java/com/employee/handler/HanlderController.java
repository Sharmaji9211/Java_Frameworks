package com.employee.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.DepartmentNotFoundException;

@RestControllerAdvice
public class HanlderController 
{
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> handleDepartmentNotFound(DepartmentNotFoundException ex)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
