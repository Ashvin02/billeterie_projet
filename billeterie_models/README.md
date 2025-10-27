## Modèles PHP

Les classes modèles se trouvent dans `billeterie_models/models/` et permettent d’accéder facilement à la base de données via PDO.

| Fichier                                                   | Description                                                               |
| --------------------------------------------------------- | ------------------------------------------------------------------------- |
| [`Billet.php`](billeterie_models/models/Billet.php)       | Gère les informations des billets (numéro, prix, événement, utilisateur). |
| [`Evenement.php`](billeterie_models/models/Evenement.php) | Représente un événement (nom, date, salle, capacité).                     |
| [`Log.php`](billeterie_models/models/Log.php)             | Enregistre les actions et événements (audit/log).                         |
| [`Payment.php`](billeterie_models/models/Payment.php)     | Gère les transactions (montant, méthode, statut, utilisateur).            |
| [`Role.php`](billeterie_models/models/Role.php)           | Définit les rôles utilisateurs (admin, client).                           |
| [`Salle.php`](billeterie_models/models/Salle.php)         | Contient les informations des salles (nom, capacité, localisation).       |
| [`User.php`](billeterie_models/models/User.php)           | Représente un utilisateur (nom, email, mot de passe, rôle).               |

Le fichier [`Database.php`](billeterie_models/Database.php) centralise la connexion PDO à la base de données.
Le fichier [`index.php`](billeterie_models/index.php) permet de tester rapidement la connexion et l’affichage des données.

---
