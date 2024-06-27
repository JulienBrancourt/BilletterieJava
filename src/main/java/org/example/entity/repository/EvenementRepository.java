package org.example.entity.repository;

import org.example.entity.Evenement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EvenementRepository {
    private EntityManager em;


    public EvenementRepository(EntityManager em) {
        this.em = em;
    }

    public void create (Evenement evenement) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(evenement);
        tx.commit();
    }

    public Evenement findById (int id) {
        return em.find(Evenement.class, id);
    }

    public void update (Evenement evenement) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(evenement);
        tx.commit();
    }

    public void delete (Evenement evenement) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(evenement);
        tx.commit();
    }
}
