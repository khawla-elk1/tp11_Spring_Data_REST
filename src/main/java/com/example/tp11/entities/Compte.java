package com.example.tp11.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor // <--- Important pour les constructeurs
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    @ManyToOne
    private Client client; // Doit s'appeler exactement "client"
}