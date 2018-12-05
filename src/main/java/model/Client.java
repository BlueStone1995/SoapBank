package main.java.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_client")
public class Client {
    @Id
    @Column(length = 8)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private Date dateNaissance;

    /**
     * Constructor
     */
    public Client() {

    }

    public Client(int num, String nom, String prenom, Date dateNaissance) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getters and Setters
     */
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }
}
