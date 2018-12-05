package main.java.model;

import javax.persistence.*;

@Entity
@Table(name = "t_account")
public class Account {
    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numAccount;

    @Column(nullable = false)
    private String libelle;

    @Column(unique = true, nullable = false, length = 27)
    private String IBAN;

    @Column(scale = 3)
    private double solde;

    @ManyToOne
    @JoinColumn(name = "agence")
    private BankBranch bankBranch;

    /**
     * Constructor
     */
    public Account() {
    }

    public Account(String numAccount, String libelle, String IBAN, int solde, BankBranch agence) {
        this.numAccount = numAccount;
        this.libelle = libelle;
        this.IBAN = IBAN;
        this.solde = solde;
        this.bankBranch = agence;
    }

    /**
     * Getters and Setters
     */
    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch agence) {
        this.bankBranch = agence;
    }

    @Override
    public String toString() {
        return "Account{" +
                "numAccount='" + numAccount + '\'' +
                ", libelle='" + libelle + '\'' +
                ", IBAN='" + IBAN + '\'' +
                ", solde=" + solde +
                ", bankBranch=" + bankBranch +
                '}';
    }
}
