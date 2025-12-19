package com.example.tp11;

import com.example.tp11.entities.Client;
import com.example.tp11.entities.Compte;
import com.example.tp11.entities.TypeCompte;
import com.example.tp11.repositories.ClientRepository;
import com.example.tp11.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            ClientRepository clientRepository,
                            RepositoryRestConfiguration restConfiguration) {
        return args -> {
            // Exposer les IDs dans l'API REST pour l'entité Compte
            restConfiguration.exposeIdsFor(Compte.class);

            // Création des clients
            // Note: Le 3ème paramètre doit correspondre à ce qui est défini dans votre entité Client (Collection ou String email)
            // Ajoutez un 4ème paramètre "null" pour la collection de comptes
            Client c1 = clientRepository.save(new Client(null, "Amal", "email@domaine.com", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", null, null));

            // Création des comptes associés aux clients
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            // Affichage des comptes dans la console
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
} // <--- Cette accolade fermait mal ou manquait dans votre code