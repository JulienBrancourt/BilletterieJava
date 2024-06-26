package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresse")
    private int idAdresse;
    private String rue;
    private String ville;

    @OneToOne(mappedBy = "adresse")
//    @JoinColumn(name = "id_client")
    private Client client;

    @OneToOne(mappedBy = "adresse")
//    @JoinColumn(name = "id_evenement")
    private Evenement evenement;

}
