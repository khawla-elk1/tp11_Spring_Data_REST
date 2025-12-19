package com.example.tp11.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor // <--- Important pour les constructeurs

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude // <--- Ajoutez cette annotation ici
    private Collection<Compte> comptes;
}