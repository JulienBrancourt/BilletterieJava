package org.example;

import org.example.entity.Adresse;
import org.example.entity.Billet;
import org.example.entity.Evenement;
import org.example.entity.Client;
import org.example.util.IHM;
import org.example.util.TypePlace;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

//        Client client3 = em.find(Client.class, 1);
//        Adresse adresse3 = em.find(Adresse.class, 1);
//
//        client3.setAdresse(adresse3);

        //creation d'évenement

//        Adresse adresse = em.find(Adresse.class, 1);
//        Evenement evenement = Evenement
//                .builder()
//                .nom("Festival1")
//                .adresse(adresse)
//                .date(LocalDate.now())
//                .heure(LocalTime.now())
//                .nbrPlace(150)
//                .build();


        //creation de billet
//        Client client = em.find(Client.class, 1);
//        Evenement evenement = em.find(Evenement.class, 1);
//        Billet billet = Billet
//                .builder()
//                .numPlace(25)
//                .client(client)
//                .evenement(evenement)
//                .typePlace(TypePlace.valueOf("GOLD"))
//                .build();
//
//        em.getTransaction().begin();
//
//        em.persist(billet);
//
//        em.getTransaction().commit();

//        System.out.println(client3.toString());


        IHM ihm = new IHM();
        ihm.start();

    }
}