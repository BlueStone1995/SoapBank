package main.java.controller;

import main.java.dao.BankBranchDao;
import main.java.dao.DAO;
import main.java.model.Account;
import main.java.model.BankBranch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankBranchController {

    private DAO<BankBranch> bankBranchDao;
    private List<BankBranch> banks;

    public BankBranchController() {
        this.bankBranchDao = new BankBranchDao();
    }

    public String getBanks() {
        if (this.banks == null) {
            this.banks = bankBranchDao.findAll();
        }
        return this.banks.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }


    public String getBank(int id) {
        BankBranch bankBranch = this.bankBranchDao.find(id);
        if (bankBranch == null) {
            return "Banque incorrect";
        }
        return bankBranch.toString();
    }

    public String addBank(String adresse, String comptes) {
        BankBranch bankBranch = new BankBranch();

        bankBranch.setAdresse(adresse);
        List<Account> accountList = new ArrayList<>();
        bankBranch.setComptes(accountList);

        this.bankBranchDao.create(bankBranch);

        return bankBranch.toString();
    }

    public String editBank(String adresse, String comptes) {
        BankBranch bankBranch = new BankBranch();

        bankBranch.setAdresse(adresse);
        List<Account> accountList = new ArrayList<>();
        bankBranch.setComptes(accountList);

        this.bankBranchDao.update(bankBranch);

        return bankBranch.toString();
    }

    public String removeBank(int id) {
        BankBranch bankBranch = this.bankBranchDao.find(id);
        this.bankBranchDao.delete(bankBranch);
        return "Banque supprimé";
    }
}
