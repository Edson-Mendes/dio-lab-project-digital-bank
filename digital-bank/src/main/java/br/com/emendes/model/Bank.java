package br.com.emendes.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe banco.
 */
public class Bank {

  private final String name;
  private Set<Account> accounts;

  public Bank(String name) {
    this.name = name;
    this.accounts = new HashSet<>();
  }

  public String getName() {
    return name;
  }

  // TODO: Buscar account por número.

}
