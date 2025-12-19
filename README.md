🏦 Système de Gestion Bancaire - Spring Boot & JPA

🚀 Technologies Utilisées
Java 17+

Spring Boot 3.2.0

Spring Data JPA : Pour l'accès aux données.

Spring Data REST : Pour exposer automatiquement les ressources via une API REST.

H2 Database : Base de données en mémoire utilisée pour le développement.

Lombok : Pour réduire le code boilerplate (Getters, Setters, Constructeurs).

Maven : Gestionnaire de dépendances.

🏗️ Architecture des Entités
L'application repose sur une relation bidirectionnelle entre deux entités principales :

Client : Défini par un ID, un nom, et un email. Un client peut posséder plusieurs comptes (@OneToMany).

Compte : Défini par un ID, un solde, une date de création et un type (ÉPARGNE/COURANT). Chaque compte appartient à un client (@ManyToOne).

🛠️ Installation et Configuration
Cloner le projet :

Bash

git clone https://github.com/votre-username/tp11-ms-banque.git
Configuration de la base de données : Par défaut, l'application utilise une base H2. La console est accessible à l'adresse suivante après le lancement : http://localhost:8080/h2-console

JDBC URL : jdbc:h2:mem:testdb

User : sa

Password : (vide)

Lancement : Exécutez la classe MsBanqueApplication depuis votre IDE ou via terminal :

Bash

mvn spring-boot:run
📋 Endpoints Principaux
Grâce à Spring Data REST, vous pouvez accéder aux ressources via :

GET /clients : Liste tous les clients.

GET /comptes : Liste tous les comptes bancaires.

GET /comptes/{id} : Détails d'un compte spécifique.

📝 Auteur
Khawla El Khassibi - Étudiante en 5ème année Ingénierie à l'EMSI Marrakech.<img width="826" height="939" alt="image" src="https://github.com/user-attachments/assets/225eec29-f309-41de-b443-58e08ab7bf80" />
