# Projet Billeterie - BTS SIO SLAM (billeterie_projet)

Ce dépôt contient deux versions :
- /version_base : structure minimale (PlantUML, SQL structure + data, README)
- /version_etendue : version améliorée avec users/admins/payments, et fichiers SQL d'extension

## Instructions rapides
1. Importer `sql/billeterie.sql` dans MySQL 8 (ou exécuter `SOURCE sql/billeterie.sql;`).
2. Ensuite exécuter `sql/data.sql` pour insérer les données de test.
3. Pour la version étendue, exécuter `sql/billeterie_extension.sql` après la création des tables de base.

## Organisation
- /version_base/model : plantuml (billeterie.puml)
- /version_base/sql   : billeterie.sql, data.sql
- /version_etendue/model : plantuml étendu
- /version_etendue/sql   : billeterie_extension.sql

## Git
```bash
git init
git add .
git commit -m "Initial - version de base + étendue"
```

