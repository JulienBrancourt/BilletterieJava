package org.example;

import org.example.entity.Adresse;
import org.example.entity.Billet;
import org.example.entity.Evenement;
import org.example.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exoBilletterieJPA");
        EntityManager em = emf.createEntityManager();

        //creation d'adresses
//        Adresse adresse = Adresse
//                .builder()
//                .rue("rue Lambda")
//                .ville("Lille")
//                .build();


        //creation de clients
        Client client1 = Client
                .builder()
                .name("Toto")
                .prenom("Nom1")
                .adresse()
                .build();


        em.getTransaction().begin();

        em.persist(adresse());

        em.getTransaction().commit();





    }
}