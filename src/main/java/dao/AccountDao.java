package main.java.dao;

import main.java.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class AccountDao implements DAO<Account> {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("jpa_unit").createEntityManager();
        }
        return em;
    }

    @Override
    public List<Account> findAll() {

        return this.getEntityManager().createQuery("select p from Account p").getResultList();
    }

    @Override
    public Account find(int id) {
        return this.getEntityManager().find(Account.class, id);
    }

    @Override
    public Account create(Account obj) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(obj);
        this.getEntityManager().getTransaction().commit();
        return obj;
    }

    @Override
    public Account update(Account obj) {
        this.getEntityManager().getTransaction().begin();
        obj = this.getEntityManager().merge(obj);
        this.getEntityManager().getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(Account obj) {
        this.getEntityManager().getTransaction().begin();
        obj = this.getEntityManager().merge(obj);
        this.getEntityManager().remove(obj);
        this.getEntityManager().getTransaction().commit();
    }
}
