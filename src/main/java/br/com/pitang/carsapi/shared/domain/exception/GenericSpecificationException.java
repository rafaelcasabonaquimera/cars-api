package br.com.pitang.carsapi.shared.domain.exception;

public class GenericSpecificationException extends RuntimeException {

  public GenericSpecificationException(String message) {
    super(message);
  }

  public GenericSpecificationException(String message, Object ... params) {
    super(String.format(message, params));
  }
}
