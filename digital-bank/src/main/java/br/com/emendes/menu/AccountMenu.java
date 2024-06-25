package br.com.emendes.menu;

import br.com.emendes.model.Account;
import br.com.emendes.model.Bank;
import lombok.RequiredArgsConstructor;

import static br.com.emendes.Main.input;

/**
 * Classe que representa o menu da conta bancaria.
 */
@RequiredArgsConstructor
public class AccountMenu {

  private final Bank bank;

  public void showOptions(Account account) {
    int option = 0;
    String headerMessage = "Welcome %s, choose the desired option".formatted(account.getClient().getName());
    do {
      String optionsMessage = """
          === %s ===
          1 - Withdraw money.
          2 - Deposit money.
          3 - Transfer money.
          4 - Print extract.
          0 - Leave.
          ===============
          """;

      System.out.printf(optionsMessage, headerMessage);
      option = getOption();
      if (option != 0) executeOption(option, account);
    } while (option != 0);
  }

  private int getOption() {
    String option = input.nextLine();

    return Integer.valueOf(option);
  }

  private void executeOption(int option, Account account) {
    switch (option) {
      case 1 -> withdrawMoney(account);
      case 2 -> depositMoney(account);
      case 3 -> transferMoney(account);
      case 4 -> System.out.println("print extract");
      default -> System.err.println("invalid option");
    }
  }

  private void withdrawMoney(Account account) {
    double value = Double.parseDouble(getInput("Enter value to withdraw: "));

    account.withdraw(value);
    System.out.printf("%s withdraw U$ %.2f successfully.%n%n", account.getClient().getName(), value);
  }

  private void depositMoney(Account account) {
    double value = Double.parseDouble(getInput("Enter value to deposit: "));

    account.deposit(value);
    System.out.printf("%s deposit U$ %.2f successfully.%n%n", account.getClient().getName(), value);
  }

  private void transferMoney(Account account) {
    int accountNumberDestiny = Integer.parseInt(getInput("Enter account number destiny: "));
    Account destinyAccount = bank.getAccountByNumber(accountNumberDestiny);

    double value = Double.parseDouble(getInput("Enter value to withdraw: "));
    account.transfer(value, destinyAccount);

    System.out.printf("%s transfer U$ %.2f successfully to %s.%n%n",
        account.getClient().getName(), value, destinyAccount.getClient().getName());
  }

  private String getInput(String inputLabel) {
    System.out.print(inputLabel);
    return input.nextLine();
  }

}
