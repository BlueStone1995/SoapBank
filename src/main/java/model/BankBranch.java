package main.java.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "t_bankBranch")
public class BankBranch {
    @Id
    @Column(length = 5)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;

    @Column(nullable = false)
    private String adresse;

    @OneToMany(mappedBy = "bankBranch")
    private Collection<Account> comptes;

    /**
     * Constructor
     */
    public BankBranch() {

        this.comptes = new HashSet<Account>();
    }

    public BankBranch(int code, String adresse, Collection<Account> comptes) {
        this.code = code;
        this.adresse = adresse;
        this.comptes = comptes;
    }

    /**
     * Getters and Setters
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Account> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Account> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "code=" + code +
                ", adresse='" + adresse + '\'' +
                ", comptes=" + comptes +
                '}';
    }
}
