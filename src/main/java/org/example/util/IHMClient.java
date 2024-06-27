package org.example.util;

import org.example.entity.Client;
import org.example.entity.repository.ClientRepository;

import org.example.entity.Adresse;
import org.example.entity.repository.AdresseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class IHMClient {
    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner sc;
    private ClientRepository clientRepository;
    private AdresseRepository adresseRepository;


    public IHMClient() {
        emf = Persistence.createEntityManagerFactory("exoBilletterieJPA");
        em = emf.createEntityManager();
        sc = new Scanner(System.in);
        clientRepository = new ClientRepository(em);
        adresseRepository = new AdresseRepository(em);
    }

    public void start() {
        String choixMethodeClient;

        System.out.println("=== Client ===");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Liste des clients");
        System.out.println("3. Modifier un client");
        System.out.println("4. Supprimer un client");

        System.out.println("Sélectionnez : ");
        choixMethodeClient = sc.nextLine();

        switch (choixMethodeClient) {
            case "1" -> createClient();
            case "2" -> readClient();
            case "3" -> updateClient();
            case "4" -> deleteClient();
            default -> {
                return;
            }
        }

    }

    public void createClient() {
        System.out.println("Saisissez le nom : ");
        String nomSaisi = sc.nextLine();

        System.out.println("Saisissez le prénom : ");
        String prenomSaisi = sc.nextLine();

        System.out.println("Adresse déjà dans la base ? ");
        System.out.println("1. Oui ");
        System.out.println("2. Non ");
        String reponseAdresse = sc.nextLine();
        Adresse adresseClient = new Adresse();
        Adresse adressfound;

        switch (reponseAdresse) {
            case "1" -> {
                System.out.println("Saisissez l'id de l'adresse");
                int id = sc.nextInt();
                sc.nextLine();

                adressfound = adresseRepository.findByID(id);
                if (adressfound != null) {
                    adresseClient = adressfound;
                }
            }
            case "2" -> {
                System.out.println("Saisir la rue");
                String rueSaisie = sc.nextLine();

                System.out.println("Saisir la ville");
                String villeSaisie = sc.nextLine();

                adresseClient = Adresse
                        .builder()
                        .rue(rueSaisie)
                        .ville(villeSaisie)
                        .build();

                adresseRepository.create(adresseClient);

            }
        }
        System.out.println("Saisissez l' âge : ");
    int ageSaisi = sc.nextInt();
        sc.nextLine();

        System.out.println("Saisissez le tel : ");
    String telSaisi = sc.nextLine();

    Client client = Client
            .builder()
            .name(nomSaisi)
            .prenom(prenomSaisi)
            .tel(telSaisi)
            .age(ageSaisi)
            .adresse(adresseClient)
            .build();


        clientRepository.create(client);

        System.out.println("Client crée : "+client);
    }

    private List<Client> readClient() {
        TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
        List<Client> clients  = query.getResultList();
        System.out.println("Liste des adresses : " +clients);
        return clients;
    }

    private void updateClient() {
        System.out.println("Quelle id voulez-vous modifier ?");
        int id = sc.nextInt();
        sc.nextLine();

        Client clientFound = clientRepository.findById(id);
        if(clientFound != null){
            System.out.println("Vous allez modifier ce client : " +clientFound);

            System.out.println("Saisir le nom");
            String nomSaisie = sc.nextLine();
            clientFound.setName(nomSaisie);

            System.out.println("Saisir le prénom");
            String prenomSaisie = sc.nextLine();
            clientFound.setPrenom(prenomSaisie);

            System.out.println("Saisir l'âge");
            int ageSaisie = sc.nextInt();
            sc.nextLine();
            clientFound.setAge(ageSaisie);

            System.out.println("Saisir le tel");
            String telSaisie = sc.nextLine();
            clientFound.setTel(telSaisie);

            System.out.println("Saisir la rue");
            String rueSaisie = sc.nextLine();
            clientFound.getAdresse().setRue(rueSaisie);

            System.out.println("Saisir la ville");
            String villeSaisie = sc.nextLine();
            clientFound.getAdresse().setVille(villeSaisie);

            clientRepository.update(clientFound);

            System.out.println("Client modifié : " +clientFound);

        }else{
            System.out.println("Client not found");
        }
    }
    public void deleteClient() {
        System.out.println("Quelle id voulez-vous supprimer ? ");
        int id = sc.nextInt();
        sc.nextLine();

        Client clientFound = clientRepository.findById(id);
        if (clientFound != null) {
            System.out.println("Vous allez supprimer ce client : " +clientFound);

            clientRepository.delete(clientFound);
            System.out.println("Client supprimé");
        } else {
            System.out.println("Client not found");
        }
    }


}

