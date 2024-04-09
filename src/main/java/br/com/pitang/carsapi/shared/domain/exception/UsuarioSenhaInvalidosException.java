package br.com.pitang.carsapi.shared.domain.exception;

public class UsuarioSenhaInvalidosException extends GenericSpecificationException {

  public UsuarioSenhaInvalidosException(String message) {
    super(message);
  }

  public UsuarioSenhaInvalidosException(String message, Object ... params) {
    super(String.format(message, params));
  }
}
