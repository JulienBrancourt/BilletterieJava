package org.example.entity.repository;

import org.example.entity.Adresse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AdresseRepository {
    private EntityManager em;

    //pour forcer la nécessité d'avoir un entity manager dans la création d'objet
    public AdresseRepository(EntityManager em) {
        this.em = em;
    }

    public void create (Adresse adresse){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(adresse);
        tx.commit();
    }

    public Adresse findByID (int id){
        return em.find(Adresse.class, id);
    }

    public void update (Adresse adresse){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(adresse);
        tx.commit();
    }

    public void delete (Adresse adresse){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(adresse);
        tx.commit();
    }
}
