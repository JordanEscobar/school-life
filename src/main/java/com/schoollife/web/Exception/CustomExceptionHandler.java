package com.schoollife.web.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	 @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	    public ResponseEntity<Object> handleMethodNotSupportedException(
	            HttpRequestMethodNotSupportedException ex) {
	        // Verificar el mensaje de la excepción
	        String mensaje = ex.getMessage();
	        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
	        
	        if (mensaje != null && mensaje.contains("Request method 'GET' is not supported")) {
	            mensaje = "El método GET no está permitido para este recurso";
	        } else {
	            mensaje = "El enlace ingresado no es válido";
	        }
	        return new ResponseEntity<>(mensaje, status);
	    }

}
