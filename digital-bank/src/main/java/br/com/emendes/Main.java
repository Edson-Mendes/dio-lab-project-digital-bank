package br.com.emendes;

import br.com.emendes.menu.InitialMenu;
import br.com.emendes.model.Bank;
import br.com.emendes.service.AccountService;

public class Main {

  public static void main(String[] args) {
    Bank bank = new Bank("Our Bank");
    AccountService accountService = new AccountService(bank);

    InitialMenu initialMenu = new InitialMenu(bank, accountService);
    initialMenu.showOptions();
  }

}