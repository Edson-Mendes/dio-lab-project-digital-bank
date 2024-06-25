package br.com.emendes.menu;

import br.com.emendes.model.Bank;
import br.com.emendes.service.AccountService;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

/**
 * Classe que representa o menu de acesso inicial.
 */
@RequiredArgsConstructor
public class InitialMenu {

  private final Bank bank;
  private final AccountService accountService;
  private final Scanner input = new Scanner(System.in);

  public void showOptions() {
    int option = 0;
    do {
      String optionsMessage = """
          === %s ===
          1 - Create Account.
          2 - Access Account.
          0 - Leave.
          ===============
          """;

      System.out.printf(optionsMessage, bank.getName());
      option = getOption();
      executeOption(option);
    } while (option != 0);

    input.close();
  }

  private int getOption() {
    String option = input.nextLine();

    return Integer.valueOf(option);
  }

  private void executeOption(int option) {
    switch (option) {
      case 1 -> accountService.createAccount();
      case 2 -> System.out.println("Access account");
      default -> System.err.println("invalid option");
    }
  }

}
