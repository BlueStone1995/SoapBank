package main.java.controller;

import main.java.dao.AccountDao;
import main.java.dao.DAO;
import main.java.model.Account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountController {

    private DAO<Account> accountDao;
    private List<Account> accounts;

    public AccountController() {
        this.accountDao = new AccountDao();
    }

    public String getAccounts() {
        if (this.accounts == null) {
            this.accounts = accountDao.findAll();
            return "Pas de comptes...";
        }
        return this.accounts.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public String getAccount(int id) {
        Account account = this.accountDao.find(id);
        if (account == null) {
            return "Compte incorrect";
        }
        return account.toString();
    }

    public String addAccount(int numAccount, String libelle, String IBAN, double solde, String agence) {
        Account account = new Account();

        account.setNumAccount(numAccount);
        account.setLibelle(libelle);
        account.setIBAN(IBAN);
        account.setSolde(solde);
        account.setBankBranch(null);

        this.accountDao.create(account);

        return account.toString();
    }

    public String editAccount(int numAccount, String libelle, String IBAN, double solde, String agence) {
        Account account = new Account();

        account.setNumAccount(numAccount);
        account.setLibelle(libelle);
        account.setIBAN(IBAN);
        account.setSolde(solde);
        account.setBankBranch(null);

        this.accountDao.update(account);

        return account.toString();
    }

    public String removeAccount(int id) {
        Account account = this.accountDao.find(id);
        this.accountDao.delete(account);
        return "Compte supprimé";
    }
}
