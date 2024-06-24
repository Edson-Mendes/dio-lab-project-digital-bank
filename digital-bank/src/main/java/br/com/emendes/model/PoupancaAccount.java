package br.com.emendes.model;

/**
 * Classe conta poupança.
 */
public class PoupancaAccount extends Account {

  public PoupancaAccount(Client client) {
    super(client);
  }

  @Override
  public void printBankStatement() {
    System.out.println("=== Extrato Conta Poupança ===");
    super.showAccountInfo();
  }

}
