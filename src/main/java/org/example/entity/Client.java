package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;
    private String name;
    private String prenom;
    private int age;
    private String tel;

    @OneToOne(mappedBy = "client")
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    private List<Billet> billets;


}
