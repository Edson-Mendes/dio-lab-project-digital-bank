package br.com.emendes.model;

import br.com.emendes.exception.AccountNotFoundException;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe banco.
 */
public class Bank {

  @Getter
  private final String name;
  private final Set<Account> accounts;

  public Bank(String name) {
    this.name = name;
    this.accounts = new HashSet<>();
  }

  /**
   * Adiciona uma conta a base de dados.
   *
   * @param account Conta a ser adiciona.
   */
  public void addAccount(Account account) {
    accounts.add(account);
  }

  /**
   * Busca uma conta por número na base de dados.
   *
   * @param number número da conta a ser buscada.
   * @return Account com dado number.
   * @throws AccountNotFoundException caso conta não seja encontrado.
   */
  public Account getAccountByNumber(int number) {
    return accounts.stream().filter(account -> account.getNumber() == number).findFirst()
        .orElseThrow(() -> new AccountNotFoundException("account not found with number: " + number));
  }

}
