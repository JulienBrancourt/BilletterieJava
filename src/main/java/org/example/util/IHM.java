package org.example.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class IHM {
    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner sc;
    private Object IHMAdresse;

    public IHM() {
        emf = Persistence.createEntityManagerFactory("exoBilletterieJPA");
        em = emf.createEntityManager();
        sc = new Scanner(System.in);
    }

    public void start() {
        String choix;

        while (true) {
            System.out.println("=== Billetterie ===");
            System.out.println("1. Adresse");

            System.out.println("Sélectionnez : ");
            choix = sc.nextLine();

            switch (choix) {
                case "1" -> IHMAdresse();
                default -> {
                    return;
                }
            }

        }
    }

    private void IHMAdresse() {
        IHMAdresse ihmAdresse = new IHMAdresse();
        ihmAdresse.start();
    }

}
