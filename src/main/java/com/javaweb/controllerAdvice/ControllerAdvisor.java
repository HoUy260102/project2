package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrorResponseDTO;

import customexception.FieldRequiredException;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(
    		FieldRequiredException ex, WebRequest request) {
		ErrorResponseDTO er = new ErrorResponseDTO();
		er.setError(ex.getMessage());
        List<String> details = new ArrayList<String>();
        details.add("Check lai");
        er.setDetail(details);
		return new ResponseEntity<>(er, HttpStatus.BAD_GATEWAY);
    }
}
