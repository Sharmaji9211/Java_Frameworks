package com.employee.handler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerController 
{
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handlerException(HttpServletRequest request,SQLException ex)throws SQLException 
	{
		String uri = request.getRequestURI();
	    if (uri.contains("/v3/api-docs") || uri.contains("/swagger-ui")) 
	    {
	        throw ex;
	    }
	    Map<String, String> error = new HashMap<>();
	    error.put("error", "Database error");
	    error.put("message", ex.getMessage());
	    return error;
	}
}
