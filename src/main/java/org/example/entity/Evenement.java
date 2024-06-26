package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evenement")
    private int idEvenement;
    private String nom;
    private LocalDate date;
    private LocalTime heure;
    @Column(name="nbr_place")
    private int nbrPlace;

    @OneToOne(mappedBy = "evenement")
    private Adresse adresse;

    @OneToMany(mappedBy = "evenement")
    private List<Billet> billets;
}
