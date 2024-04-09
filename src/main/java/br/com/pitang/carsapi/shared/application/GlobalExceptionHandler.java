package br.com.pitang.carsapi.shared.application;

import br.com.pitang.carsapi.shared.domain.exception.EmailJaExistenteException;
import br.com.pitang.carsapi.shared.domain.exception.GenericSpecificationException;
import br.com.pitang.carsapi.shared.domain.exception.LoginJaExistenteException;
import br.com.pitang.carsapi.shared.domain.exception.UsuarioSenhaInvalidosException;
import br.com.pitang.carsapi.shared.vo.ResponseError;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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
            ResponseError error = responseError(String.format("Erro interno do servidor, mensagem interna: %s", e.getMessage()),00);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    private ResponseEntity<Object> handleAuthenticationException(GenericSpecificationException e, WebRequest request) {
        if (e.getClass().isAssignableFrom(UsuarioSenhaInvalidosException.class)) {
            ResponseError error = responseError(e.getMessage(),1);
            return handleExceptionInternal(e, error, headers(), HttpStatus.UNAUTHORIZED, request);
        }
        ResponseError error = responseError(e.getMessage(),0);
        return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({GenericSpecificationException.class})
    private ResponseEntity<Object> handleBusinessException(GenericSpecificationException e, WebRequest request) {

        if (e instanceof EmailJaExistenteException) {
            ResponseError error = responseError(e.getMessage(),2);
            return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
        }
        if (e instanceof LoginJaExistenteException) {
            ResponseError error = responseError(e.getMessage(),3);
            return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
        }
        if (e.getMessage().contains("Invalid fields")) {
            ResponseError error = responseError(e.getMessage(),4);
            return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
        }
        if (e.getMessage().contains("Missing fields")) {
            ResponseError error = responseError(e.getMessage(),5);
            return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
        }
        ResponseError error = responseError(e.getMessage(),6);
        return handleExceptionInternal(e, error, headers(), HttpStatus.BAD_REQUEST, request);
    }
}
