package org.example.util;

import org.example.entity.Adresse;
import org.example.entity.repository.AdresseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class IHMAdresse {

    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner sc;
    private AdresseRepository adresseRepository;

    public IHMAdresse() {
        emf = Persistence.createEntityManagerFactory("exoBilletterieJPA");
        em = emf.createEntityManager();
        sc = new Scanner(System.in);
        adresseRepository = new AdresseRepository(em);
    }

    public void start() {

        String choixMethodeAdresse;

        System.out.println("=== Adresse ===");
        System.out.println("1. Ajouter une adresse");
        System.out.println("2. Liste des adresses");
        System.out.println("3. Modifier une adresse");
        System.out.println("4. Supprimer une adresse");

        System.out.println("Sélectionnez : ");
        choixMethodeAdresse = sc.nextLine();

        switch (choixMethodeAdresse) {
            case "1" -> createAdresse();
            case "2" -> readAdresse();
            case "3" -> updateAdresse();
            case "4" -> deleteAdresse();
            default -> {
                return;
            }
        }
    }



    private void createAdresse() {
        System.out.println("Saisir la rue");
        String rueSaisie = sc.nextLine();

        System.out.println("Saisir la ville");
        String villeSaisie = sc.nextLine();

        Adresse adresse = Adresse
                .builder()
                .rue(rueSaisie)
                .ville(villeSaisie)
                .build();

        adresseRepository.create(adresse);

        System.out.println("Adresse crée" + adresse);

    }

    private List<Adresse> readAdresse() {
        TypedQuery<Adresse> query = em.createQuery("select a from Adresse a", Adresse.class);
        List<Adresse> adresses  = query.getResultList();
        System.out.println("Liste des adresses : " +adresses);
        return adresses;
    }

    private void updateAdresse() {
        System.out.println("Quelle id voulez-vous modifier ?");
        int id = sc.nextInt();
        sc.nextLine();

        Adresse adressFound = adresseRepository.findByID(id);
        if(adressFound != null){
            System.out.println("Vous allez modifier cette adresse : " +adressFound);

            System.out.println("Saisir la rue");
            String rueSaisie = sc.nextLine();
            adressFound.setRue(rueSaisie);

            System.out.println("Saisir la ville");
            String villeSaisie = sc.nextLine();
            adressFound.setVille(villeSaisie);
            adresseRepository.update(adressFound);
            System.out.println("Adresse modifiée: " +adressFound);


        }else{
            System.out.println("Adress not found");
        }
    }

    private void deleteAdresse() {
        System.out.println("Quelle id voulez-vous supprimer ?");
        int id = sc.nextInt();
        sc.nextLine();

        Adresse adressFound = adresseRepository.findByID(id);
        if(adressFound != null){
            System.out.println("Vous allez supprimer cette adresse : " +adressFound);

            adresseRepository.delete(adressFound);
            System.out.println("Adresse supprimée");

        }else{
            System.out.println("Adress not found");
        }
    }


}
