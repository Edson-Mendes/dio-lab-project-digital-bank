package br.com.emendes.model;

/**
 * Classe conta corrente.
 */
public class CorrenteAccount extends Account {

  public CorrenteAccount(Client client) {
    super(client);
  }

  @Override
  public void printBankStatement() {
    System.out.println("-----------------------");
    System.out.println("=== Extrato Conta Corrente ===");
    super.showAccountInfo();
    System.out.println("-----------------------");
  }

}
