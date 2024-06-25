package br.com.emendes;

import br.com.emendes.menu.InitialMenu;
import br.com.emendes.model.Bank;

public class Main {

  public static void main(String[] args) {
    Bank bank = new Bank("Our Bank");

    InitialMenu initialMenu = new InitialMenu(bank);
    initialMenu.showOptions();
  }

}