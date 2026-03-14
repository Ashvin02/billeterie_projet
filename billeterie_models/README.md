## Modèles PHP

Les classes modèles se trouvent dans `billeterie_models/models/` et permettent d’accéder facilement à la base de données via PDO.

| Fichier                                                   | Description                                                               |
| --------------------------------------------------------- | ------------------------------------------------------------------------- |
| [`Billet.java`](billeterie_models/models/Billet.java)       | Gère les informations des billets (numéro, prix, événement, utilisateur). |
| [`Evenement.java`](billeterie_models/models/Evenement.java) | Représente un événement (nom, date, salle, capacité).                     |
| [`Log.java`](billeterie_models/models/Log.java)             | Enregistre les actions et événements (audit/log).                         |
| [`Payment.java`](billeterie_models/models/Payment.java)     | Gère les transactions (montant, méthode, statut, utilisateur).            |
| [`Role.java`](billeterie_models/models/Role.java)           | Définit les rôles utilisateurs (admin, client).                           |
| [`Salle.java`](billeterie_models/models/Salle.java)         | Contient les informations des salles (nom, capacité, localisation).       |
| [`User.java`](billeterie_models/models/User.java)           | Représente un utilisateur (nom, email, mot de passe, rôle).               |
| [`Database.php`](billeterie_models/models/Database.java)    | centralise la connexion PDO à la base de données.                         |
| [`index.php`](billeterie_models/models/index.java)          | permet de tester rapidement la connexion et l’affichage des données.      |


