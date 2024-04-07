package br.com.pitang.carsapi.shared.domain.exception;

public class EmailJaExistenteException extends GenericSpecificationException {

  public EmailJaExistenteException(String message) {
    super(message);
  }

  public EmailJaExistenteException(String message, Object ... params) {
    super(String.format(message, params));
  }
}
