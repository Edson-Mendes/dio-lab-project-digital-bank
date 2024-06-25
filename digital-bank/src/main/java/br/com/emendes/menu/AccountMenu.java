package br.com.emendes.menu;

import br.com.emendes.model.Account;

import static br.com.emendes.Main.input;

/**
 * Classe que representa o menu da conta bancaria.
 */
public class AccountMenu {

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
      if (option != 0) executeOption(option);
    } while (option != 0);
  }

  private int getOption() {
    String option = input.nextLine();

    return Integer.valueOf(option);
  }

  private void executeOption(int option) {
    switch (option) {
      case 1 -> System.out.println("withdraw money");
      case 2 -> System.out.println("deposit money");
      case 3 -> System.out.println("transfer money");
      case 4 -> System.out.println("print extract");
      default -> System.err.println("invalid option");
    }
  }

}
