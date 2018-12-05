package main.java.dao;

import main.java.model.BankBranch;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class BankBranchDao implements DAO<BankBranch> {

    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory("jpa_unit").createEntityManager();
        }
        return em;
    }

    @Override
    public List<BankBranch> findAll() {

        return this.getEntityManager().createQuery("select p from BankBranch p").getResultList();
    }

    @Override
    public BankBranch find(int id) {
        return this.getEntityManager().find(BankBranch.class, id);
    }

    @Override
    public BankBranch create(BankBranch obj) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().persist(obj);
        this.getEntityManager().getTransaction().commit();
        return obj;
    }

    @Override
    public BankBranch update(BankBranch obj) {
        this.getEntityManager().getTransaction().begin();
        obj = this.getEntityManager().merge(obj);
        this.getEntityManager().getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(BankBranch obj) {
        this.getEntityManager().getTransaction().begin();
        obj = this.getEntityManager().merge(obj);
        this.getEntityManager().remove(obj);
        this.getEntityManager().getTransaction().commit();
    }
}
