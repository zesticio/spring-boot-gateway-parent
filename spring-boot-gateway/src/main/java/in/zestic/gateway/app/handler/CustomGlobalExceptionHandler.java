package in.zestic.gateway.app.handler;

import in.zestic.gateway.app.base.Result;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public final ResponseEntity<Result> exceptionHandler(Exception ex, WebRequest request) {
        logger.error("Internal error.", ex);
        return createErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    protected ResponseEntity<Result> createErrorResponseEntity(Exception exception, HttpStatus status, Integer code) {
        logger.error(String.format("Error: %s with code: %d", exception.getMessage(), code), exception);
        Result<Void> result = new Result(code, exception.getMessage());
        ResponseEntity<Result> response = new ResponseEntity<>(result, status);
        return response;

    }
}
