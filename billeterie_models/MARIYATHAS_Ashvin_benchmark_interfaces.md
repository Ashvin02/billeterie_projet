# 🎯 Benchmark des Frameworks d’interfaces graphiques Java
**Auteur :** Mariyathas Ashvin
**Projet :** Application de billetterie
**Objectif :** Choisir le framework Java le plus adapté pour créer l’interface graphique du projet.

---

## ⚙️ 1. Mes besoins

Je dois concevoir une **interface graphique simple, fluide et rapide à développer**, pour une **application de billetterie** en Java.  
L’objectif est de pouvoir :  
- Afficher des formulaires (connexion, réservation, etc.)  
- Gérer des boutons, tableaux et menus  
- Se connecter à la base de données  
- Fournir une interface agréable, claire et responsive

---

## 🧩 2. Critères et poids

| Critères | Description | Poids |
|-----------|--------------|--------|
| Intégré à Java | Nécessite ou non d’ajouter un SDK externe | 8 |
| Installation simple | Facilité d’installation et de configuration | 8 |
| Documentation complète | Présence de docs officielles et tutos | 7 |
| Apprentissage facile | Temps d’adaptation et courbe d’apprentissage | 9 |
| Mises à jour régulières | Suivi du framework par la communauté | 5 |
| Architecture MVC possible | Permet une bonne séparation du code | 6 |
| Outils visuels (drag & drop) | Existe-t-il des outils pour créer des interfaces rapidement | 6 |
| Qualité du rendu graphique | Modernité et aspect visuel | 8 |
| Performance | Consommation de ressources et fluidité | 7 |
| Compatibilité | Fonctionne sans dépendances complexes | 9 |

---

## 🧠 3. Frameworks comparés

| Critères (poids) | **Swing** | **JavaFX** | **SWT** |
|------------------|:----------:|:-----------:|:--------:|
| Intégré à Java (8) | ✅ 10 | ⚠️ 6 | ❌ 5 |
| Installation simple (8) | ✅ 10 | ⚠️ 7 | ❌ 6 |
| Documentation (7) | ✅ 9 | ✅ 9 | ⚠️ 6 |
| Apprentissage facile (9) | ✅ 10 | ⚠️ 7 | ❌ 5 |
| Mises à jour régulières (5) | ⚠️ 6 | ✅ 9 | ⚠️ 7 |
| MVC possible (6) | ⚠️ 7 | ✅ 10 | ✅ 8 |
| Outils visuels (6) | ⚠️ 7 | ✅ 9 | ⚠️ 6 |
| Qualité du rendu (8) | ⚠️ 6 | ✅ 10 | ⚠️ 7 |
| Performance (7) | ⚠️ 7 | ✅ 9 | ✅ 8 |
| Compatibilité (9) | ✅ 10 | ⚠️ 8 | ❌ 6 |
| **Total pondéré** | **782 / 900** | **840 / 900** | **676 / 900** |

---

## 🏁 4. Recommandations

### 🔹 1. **JavaFX**
- ✅ Moderne, fluide et maintenu par Oracle  
- ✅ Compatible avec le modèle MVC  
- ✅ Très bon rendu visuel  
- ⚠️ Légèrement plus complexe à mettre en place  

**👉 Recommandé pour un projet professionnel ou une application évolutive.**

---

### 🔹 2. **Swing**
- ✅ Intégré nativement au JDK  
- ✅ Installation et apprentissage très simples  
- ✅ Idéal pour les projets étudiants ou prototypes rapides  
- ⚠️ Rendu graphique plus ancien  

**👉 Recommandé pour un projet rapide ou une première approche.**

---

## 🧭 5. Accessibilité (mon choix)

Pour mon projet **de billetterie en Java**, je choisis de **commencer avec Swing**.  
C’est le **framework le plus accessible** pour un développement rapide, avec une **installation directe** et une **courbe d’apprentissage adaptée** à notre niveau BTS SIO.  

---

✅ **Choix final :**  
1. **Swing** → pour la première version (simple, rapide)  
