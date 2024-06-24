package br.com.emendes.model;

/**
 * Interface com as funcionalidades básicas de uma Conta.
 */
public interface IAccount {

  /**
   * Método para saque de uma conta.
   *
   * @param value valor a ser sacado da conta.
   * @throws IllegalArgumentException caso value seja 0 ou negativo.
   */
  void withdraw(double value);

  /**
   * Método para depositar um valor na conta.
   *
   * @param value valor a ser depositado na conta.
   * @throws IllegalArgumentException caso value seja 0 ou negativo.
   */
  void deposit(double value);

  /**
   * Método para transferência entre contas.
   *
   * @param value           valor a ser transferido para outra conta.
   * @param receiverAccount conta de destino da transferência do valor.
   * @throws IllegalArgumentException caso value seja 0 ou negativo.
   */
  void transfer(double value, IAccount receiverAccount);

  /**
   * Imprime o extrato bancário da conta.
   */
  void printBankStatement();

}
