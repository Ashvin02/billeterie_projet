# Projet Billeterie - BTS SIO SLAM (billeterie_projet)

Ce dépôt contient deux versions :

* **/version_base** : structure minimale (PlantUML, SQL structure + data, README)
* **/version_etendue** : version améliorée avec users/admins/payments, et fichiers SQL d'extension

---

## Instructions rapides

1. Importer `version_base/sql/billeterie.sql` dans MySQL 8 (ou exécuter `SOURCE version_base/sql/billeterie.sql;`)
2. Exécuter `version_base/sql/data.sql` pour insérer les données de test
3. Pour la version étendue, exécuter `version_etendue/sql/billeterie_extension.sql` après la création des tables de base

---

## Organisation

```
/version_base/model       : PlantUML (billeterie.puml)
/version_base/sql         : billeterie.sql, data.sql
/version_etendue/model    : PlantUML étendu
/version_etendue/sql      : billeterie_extension.sql
/billeterie_models/       : classes PHP pour accéder à la base (Database.php + models/)
```

---

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

## Git

```bash
git init
git add .
git commit -m "Initial - version de base + étendue + modèles PHP"
git push origin main
```

---

## Auteur

**Mariyathas Ashvin**
*BTS SIO – Option SLAM*
H3 Hitema
