package com.capgemini.healthcaresystem.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {NoCentersAreAvailableException.class})
	public ErrorInfo handleCenterAlreadyExistsException(NoCentersAreAvailableException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {SpecifiedCenterDoesnotExistException.class})
	public ErrorInfo handleSpecifiedCenterDoesnotExistException(SpecifiedCenterDoesnotExistException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {CenterAlreadyExistsException.class})
	public ErrorInfo handleCenterAlreadyExistsException(CenterAlreadyExistsException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {CenterNameAlreadyExistsException.class})
	public ErrorInfo handleCenterNameAlreadyExistsException(CenterNameAlreadyExistsException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}

}
