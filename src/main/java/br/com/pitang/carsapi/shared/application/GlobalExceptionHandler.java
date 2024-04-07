package br.com.pitang.carsapi.shared.application;

import br.com.pitang.carsapi.shared.domain.exception.EmailJaExistenteException;
import br.com.pitang.carsapi.shared.domain.exception.GenericSpecificationException;
import br.com.pitang.carsapi.shared.vo.ResponseError;
import jakarta.annotation.Resource;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String message, Integer errorCode){
        ResponseError responseError = new ResponseError();
        responseError.setErrorCode(errorCode);
        responseError.setMessage(message);
        return responseError;
    }
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((GenericSpecificationException) exception.getUndeclaredThrowable(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message,123);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }
    @ExceptionHandler({GenericSpecificationException.class})
    private ResponseEntity<Object> handleBusinessException(GenericSpecificationException e, WebRequest request) {
        if (e.getClass().isAssignableFrom(EmailJaExistenteException.class)) {
            ResponseError error = responseError(e.getMessage(),23);
            return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
        }
        ResponseError error = responseError(e.getMessage(),123);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}
