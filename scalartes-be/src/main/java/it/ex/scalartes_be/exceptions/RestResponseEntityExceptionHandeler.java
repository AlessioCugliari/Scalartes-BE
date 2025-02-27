package it.ex.scalartes_be.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandeler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundElementException.class)
    protected ResponseEntity<Object> handleNotFoundElementException(Exception e, WebRequest request){

        String bodyOfResponse = NotFoundElementException.class.getName() + " " + e.getMessage();
        return handleExceptionInternal(e,bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT,request);
    }
}
