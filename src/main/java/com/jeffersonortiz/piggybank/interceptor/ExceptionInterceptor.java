package com.jeffersonortiz.piggybank.interceptor;

import com.jeffersonortiz.piggybank.domain.dto.ErrorResponseDTO;
import com.jeffersonortiz.piggybank.exception.RestServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestServiceException.class)
    public final ResponseEntity<Object> handleAllExceptions(RestServiceException ex) {
        ErrorResponseDTO exceptionResponse = ErrorResponseDTO.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
