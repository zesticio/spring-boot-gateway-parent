package com.zestic.gateway.app.handler;

import com.zestic.springboot.common.entity.Result;
import com.zestic.springboot.common.handlers.BaseGlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

public class CustomGlobalExceptionHandler extends BaseGlobalExceptionHandler {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    protected ResponseEntity<Result> createErrorResponseEntity(Exception exception, HttpStatus status, Integer code) {
        logger.error(String.format("Error: %s with code: %d", exception.getMessage(), code), exception);
        Result<Void> result = new Result(code, exception.getMessage());
        ResponseEntity<Result> response = new ResponseEntity<>(result, status);
        return response;
    }
}
