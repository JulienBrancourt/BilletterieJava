package org.example.entity.repository;

import org.example.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClientRepository {
    private EntityManager em;


    public ClientRepository(EntityManager em) {
        this.em = em;
    }

    public void create (Client client) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(client);
        tx.commit();
    }

    public Client findById (int id) {
        return em.find(Client.class, id);
    }

    public void update (Client client) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(client);
        tx.commit();
    }

    public void delete (Client client) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(client);
        tx.commit();
    }
}



