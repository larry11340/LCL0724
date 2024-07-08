package com.example.toolrental.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ToolRentalControllerAdvice {

    @ExceptionHandler(ToolRentalException.class)
    public ResponseEntity<ErrorMessage> handleRentalToolException(ToolRentalException rt) {
        ErrorMessage er = new ErrorMessage(rt.getErrorCodes().getName(), rt.getMessage());
        return ResponseEntity.status(rt.getErrorCodes().getHttpStatus()).body(er);
    }

    @ExceptionHandler (WebExchangeBindException.class)
    public ResponseEntity<Object> handleWebExchangeBindException(
            WebExchangeBindException e) {
        final BindingResult bindingResult = e.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> field = new HashMap<>();
        fieldErrors.forEach(error -> field.put(error.getField(),error.getDefaultMessage()));
        ErrorMessage er = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), field);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler (ServerWebInputException.class)
    public ResponseEntity<Object> handleServerWebInputException(
            ServerWebInputException e) {
        ErrorMessage er = new ErrorMessage(HttpStatus.BAD_REQUEST.name(), e.getCause().getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }
}
