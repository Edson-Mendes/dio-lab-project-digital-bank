package br.com.emendes.model;

import lombok.Getter;

/**
 * Classe base para contas corrente e poupança.
 */
@Getter
public abstract class Account implements IAccount {

  private static final int DEFAULT_BRANCH = 1;
  private static int numberSequence = 1000;

  protected final int branch;
  protected final int number;
  protected final Client client;
  protected double balance;

  protected Account(Client client) {
    this.client = client;
    this.branch = DEFAULT_BRANCH;
    this.number = numberSequence++;
    this.balance = 0.0;
  }

  @Override
  public void withdraw(double value) {
    checkMoneyValue(value);
//    checkBalance(value);
    balance -= value;
  }

  @Override
  public void deposit(double value) {
    checkMoneyValue(value);
    balance += value;
  }

  @Override
  public void transfer(double value, IAccount receiverAccount) {
    checkMoneyValue(value);
    this.withdraw(value);
    receiverAccount.deposit(value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Account account = (Account) o;
    return number == account.number;
  }

  @Override
  public int hashCode() {
    return number;
  }

  /**
   * Imprimi as informações básica da conta.
   */
  protected void showAccountInfo() {
    System.out.printf("Client: %s%n", this.client.getName());
    System.out.printf("Branch: %d%n", this.branch);
    System.out.printf("Number: %d%n", this.number);
    System.out.printf("Balance: %.2f%n", this.balance);
  }

  /**
   * Verifica se um valor monetário é maior que zero.
   *
   * @param value valor que será verificado.
   * @throws IllegalArgumentException caso o value não seja válido.
   */
  private static void checkMoneyValue(double value) {
    if (moneyValidator(value)) {
      throw new IllegalArgumentException("value must not be negative or zero.");
    }
  }

  /**
   * Verifica se value é maior que zero.
   *
   * @param value parâmetro a ser validado.
   * @return {@code true} se value for válido, {@code false} caso contrário.
   */
  private static boolean moneyValidator(double value) {
    return value > 0;
  }

}
