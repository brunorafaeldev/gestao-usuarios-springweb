package com.github.brunorafaeldev.api_web_first_project.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.UndeclaredThrowableException;

@ControllerAdvice // 💡 ESSENCIAL: Avisa o Spring que esta classe cuida dos erros da API
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired 
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String message, HttpStatus statusCode) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

   @ExceptionHandler(Exception.class)
protected ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
    if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
        UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
        return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
    } else {
        // Mudamos aqui para pegar direto a mensagem do erro sem precisar do messageSource
        String message = e.getMessage() != null ? e.getMessage() : "Erro interno no servidor";
        ResponseError error = responseError(message, HttpStatus.INTERNAL_SERVER_ERROR);
        return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}

    @ExceptionHandler({BusinessException.class})
    protected ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
        ResponseError error = responseError(e.getMessage(), HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}