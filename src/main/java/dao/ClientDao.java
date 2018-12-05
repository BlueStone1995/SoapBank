package main.java.dao;

import main.java.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ClientDao implements DAO<Client> {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("jpa_unit").createEntityManager();
        }
        return em;
    }

    @Override
    public List<Client> findAll() {
        return this.getEntityManager().createQuery("select p from Client p").getResultList();
    }

    @Override
    public Client find(int id) {
        return this.getEntityManager().find(Client.class, id);
    }

    @Override
    public Client create(Client obj) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(obj);
        this.getEntityManager().getTransaction().commit();
        return obj;
    }

    @Override
    public Client update(Client obj) {
        this.getEntityManager().getTransaction().begin();
        obj = this.getEntityManager().merge(obj);
        this.getEntityManager().getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(Client obj) {
        this.getEntityManager().getTransaction().begin();
        obj = this.getEntityManager().merge(obj);
        this.getEntityManager().remove(obj);
        this.getEntityManager().getTransaction().commit();
    }
}
