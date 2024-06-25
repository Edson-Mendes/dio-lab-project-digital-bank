package br.com.emendes.menu;

import br.com.emendes.model.Bank;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

/**
 * Classe que representa o menu de acesso inicial.
 */
@RequiredArgsConstructor
public class InitialMenu {

  private final Bank bank;

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
  }

  private int getOption() {
    Scanner input = new Scanner(System.in);

    return Integer.parseInt(input.nextLine());
  }

  private void executeOption(int option) {
    switch (option) {
      case 1 -> System.out.println("Create account!");
      case 2 -> System.out.println("Access account");
      default -> System.err.println("invalid option");
    }
  }

}
