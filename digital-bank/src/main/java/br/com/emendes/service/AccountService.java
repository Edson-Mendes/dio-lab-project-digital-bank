package br.com.emendes.service;

import br.com.emendes.exception.AccountNotFoundException;
import br.com.emendes.menu.AccountMenu;
import br.com.emendes.model.*;
import lombok.RequiredArgsConstructor;

import static br.com.emendes.Main.input;

/**
 * Service responsável pelo recurso Account.
 */
@RequiredArgsConstructor
public class AccountService {

  private final Bank bank;
  private final AccountMenu accountMenu;

  public void createAccount() {
    String clientName = getInput("Enter your name: ");
    Client newClient = new Client(clientName);

    String accountType = getInput("""
        Choose account type:
        1 - Corrente Account
        2 - Poupança Account
        """);

    Account account = switch (accountType) {
      case "1" -> new CorrenteAccount(newClient);
      case "2" -> new PoupancaAccount(newClient);
      default -> throw new IllegalArgumentException("invalid option");
    };

    saveAccount(account);
    System.out.println("account created successfully!");
  }

  public void accessAccount() {
    int accountNumber = Integer.parseInt(getInput("Enter your account number:"));

    try {
      Account account = bank.getAccountByNumber(accountNumber);
      accountMenu.showOptions(account);
    } catch (AccountNotFoundException e) {
      System.err.println("---------------------------------");
      System.err.println("Account not found with number: " + accountNumber);
      System.err.println("---------------------------------");
    }
  }

  private String getInput(String inputLabel) {
    System.out.print(inputLabel);
    return input.nextLine();
  }

  private void saveAccount(Account account) {
    bank.addAccount(account);
  }

}
