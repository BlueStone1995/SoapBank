package main.java.controller;

import main.java.dao.ClientDao;
import main.java.dao.DAO;
import main.java.model.Client;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClientController {

    private DAO<Client> clientDao;
    private List<Client> clients;

    public ClientController() {
        this.clientDao = new ClientDao();
    }


    public String getClients() {
        if (this.clients == null) {
            this.clients = clientDao.findAll();
        }
        return this.clients.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public Client getClient(int id) {
        return this.clientDao.find(id);
    }

    public String addClient(String nom, String prenom, int naissance) {
        Client client = new Client();

        client.setNom(nom);
        client.setPrenom(prenom);
        Date date = new Date();
        client.setDateNaissance(date);

        this.clientDao.create(client);

        return client.toString();
    }

    public String editClient(String nom, String prenom, int naissance) {
        Client client = new Client();

        client.setNom(nom);
        client.setPrenom(prenom);
        Date date = new Date();
        client.setDateNaissance(date);

        this.clientDao.update(client);

        return client.toString();
    }

    public String removeClient(int id) {
        Client client = this.clientDao.find(id);
        this.clientDao.delete(client);
        return "Client supprimé";
    }
}
