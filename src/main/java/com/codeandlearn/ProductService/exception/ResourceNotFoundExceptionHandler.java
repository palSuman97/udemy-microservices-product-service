package com.codeandlearn.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ResourceNotFoundExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResourceNotFoundResponseEntity errorMsg(ResourceNotFoundException resourceNotFoundException) {
		
		ResourceNotFoundResponseEntity errorMsg= 
				new ResourceNotFoundResponseEntity(HttpStatus.NOT_FOUND, resourceNotFoundException.getMessage(), resourceNotFoundException.getErrorCode());
		return errorMsg;
	}
	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public CustomResponseEntity errorMsg(CustomException customException) {
		
		CustomResponseEntity errorMsg= 
				new CustomResponseEntity(HttpStatus.BAD_REQUEST, customException.getMessage());
		return errorMsg;
	}
	
	@ExceptionHandler(CustomExceptionExternal.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public CustomResponseEntityExternal errorMsg(CustomExceptionExternal customExceptionExternal) {
		
		CustomResponseEntityExternal errorMsg = 
				new CustomResponseEntityExternal(customExceptionExternal.getMessage(), customExceptionExternal.getErrorCode(), customExceptionExternal.getErrorStatus());
		return errorMsg;
	}
}
