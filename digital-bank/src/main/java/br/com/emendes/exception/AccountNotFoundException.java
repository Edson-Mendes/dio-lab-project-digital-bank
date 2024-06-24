package br.com.emendes.exception;

/**
 * Exception a ser lançada quando Account não for encontrado.
 */
public class AccountNotFoundException extends RuntimeException {

  public AccountNotFoundException(String message) {
    super(message);
  }

}
