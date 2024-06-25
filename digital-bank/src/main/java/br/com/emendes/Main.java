package br.com.emendes;

import br.com.emendes.menu.AccountMenu;
import br.com.emendes.menu.InitialMenu;
import br.com.emendes.model.Bank;
import br.com.emendes.service.AccountService;

import java.util.Scanner;

public class Main {

  public static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    Bank bank = new Bank("Our Bank");
    AccountMenu accountMenu = new AccountMenu(bank);
    AccountService accountService = new AccountService(bank, accountMenu);

    InitialMenu initialMenu = new InitialMenu(bank, accountService);
    initialMenu.showOptions();

    input.close();
  }

}