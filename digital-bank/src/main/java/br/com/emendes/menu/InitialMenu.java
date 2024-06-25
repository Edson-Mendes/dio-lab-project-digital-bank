package br.com.emendes.menu;

import br.com.emendes.model.Bank;
import br.com.emendes.service.AccountService;
import lombok.RequiredArgsConstructor;

import static br.com.emendes.Main.input;

/**
 * Classe que representa o menu de acesso inicial.
 */
@RequiredArgsConstructor
public class InitialMenu {

  private final Bank bank;
  private final AccountService accountService;

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
      if (option != 0) executeOption(option);
    } while (option != 0);
  }

  private int getOption() {
    String option = input.nextLine();

    return Integer.valueOf(option);
  }

  private void executeOption(int option) {
    switch (option) {
      case 1 -> accountService.createAccount();
      case 2 -> accountService.accessAccount();
      default -> System.err.println("invalid option");
    }
  }

}
