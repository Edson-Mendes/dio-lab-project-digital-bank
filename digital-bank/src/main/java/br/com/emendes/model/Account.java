package br.com.emendes.model;

import lombok.Getter;

/**
 * Classe base para contas corrente e poupança.
 */
@Getter
public abstract class Account implements IAccount {

  private static final int DEFAULT_BRANCH = 1;
  private static int NUMBER_SEQUENCE = 1000;

  protected int branch;
  protected int number;
  protected double balance;
  protected Client client;

  public Account(Client client) {
    this.client = client;
  }

}
