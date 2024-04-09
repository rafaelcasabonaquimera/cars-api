package br.com.pitang.carsapi.shared.domain.exception;

public class LoginJaExistenteException extends GenericSpecificationException {

  public LoginJaExistenteException(String message) {
    super(message);
  }

  public LoginJaExistenteException(String message, Object ... params) {
    super(String.format(message, params));
  }
}
