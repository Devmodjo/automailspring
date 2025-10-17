# 📘 Mail Automation API

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen?style=flat-square&logo=spring-boot)
![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=java)
![API REST](https://img.shields.io/badge/API-REST-blue?style=flat-square)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%202.6.0-green?style=flat-square&logo=swagger)
![H2 Database](https://img.shields.io/badge/Database-H2-lightblue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-yellowgreen?style=flat-square)

---

* **Version :** 1.0.0
* **Auteur :**  Modjo Victor
* **Date :** Octobre 2025
* **Technologie :** Spring Boot 3 / Java 17+ / Springdoc OpenAPI 2.6.0
* **Base de données :** H2 (persistante)
* **Documentation interactive :** http://localhost:7777/swagger-ui.html

---

## 🧭 1. Présentation générale

L'**API Mail Automation** permet la **gestion des utilisateurs** et l'**envoi automatique d'e-mails de bienvenue** après l'inscription.
Elle est développée en **Spring Boot** et documentée via **Swagger / OpenAPI**.

### 🎯 Objectifs principaux :
- Créer et enregistrer des utilisateurs dans la base de données
- Envoyer automatiquement un **mail de bienvenue** après chaque inscription
- Consulter la liste complète des utilisateurs enregistrés
- Permettre une documentation interactive et testable via Swagger

---

## ⚙️ 2. Technologies utilisées

| Outil / Framework | Rôle |
|-------------------|------|
| **Spring Boot 3** | Cadre principal de développement |
| **Spring Web** | Exposition des endpoints REST |
| **Spring Data JPA** | Accès et persistance des données |
| **H2 Database** | Base de données légère et intégrée |
| **Springdoc OpenAPI** | Génération automatique de la documentation Swagger |
| **Lombok** | Réduction du code boilerplate (constructeurs, getters/setters) |
| **JavaMailSender (Spring)** | Service d'envoi d'e-mails |
| **Maven** | Gestion des dépendances |

---

## 🧱 3. Architecture du projet

```
com.example.mailapi
├── controller
│   └── UserController.java
├── entity
│   └── Users.java
├── repository
│   └── UserRepository.java
├── service
│   └── EmailService.java
├── config
│   └── OpenApiConfig.java
└── AutomaticMailApplication.java
```

---

## 📡 4. Endpoints disponibles

### **Base URL :**
```
http://localhost:7777/api/users
```

---

### 📍 1️⃣ POST /api/users

#### ➤ Description :
Crée un nouvel utilisateur et lui envoie automatiquement un e-mail de bienvenue.

#### ➤ Requête :
**Content-Type :** `application/json`

##### Exemple du corps de requête :
```json
{
  "username": "Alice Dupont",
  "email": "alice.dupont@example.com"
}
```

#### ➤ Réponse (200 - OK) :
Type : `application/json`

Exemple de réponse :
```json
{
  "id": 1,
  "username": "Alice Dupont",
  "email": "alice.dupont@example.com"
}
```

#### ➤ Codes de réponse possibles :

| Code | Signification |
|------|---------------|
| 200 | Utilisateur créé et e-mail envoyé avec succès |
| 400 | Données invalides ou incomplètes |
| 500 | Erreur interne (ex : échec de l'envoi d'e-mail) |

#### ➤ Exemple de mail envoyé :
```
Objet : Bienvenue sur Mail Automation, Alice Dupont 🎉

Bonjour Alice Dupont,

Nous sommes heureux de vous compter parmi nous !
Votre inscription a bien été enregistrée.

L'équipe Mail Automation.
```

---

### 📍 2️⃣ GET /api/users

#### ➤ Description :
Récupère la liste complète de tous les utilisateurs enregistrés dans la base de données.

#### ➤ Requête :
Aucun paramètre requis.

#### ➤ Réponse (200 - OK) :
Type : `application/json`

Exemple de réponse :
```json
[
  {
    "id": 1,
    "username": "Alice Dupont",
    "email": "alice.dupont@example.com"
  },
  {
    "id": 2,
    "username": "Marc Tchoumi",
    "email": "marc.tchoumi@example.com"
  }
]
```

#### ➤ Codes de réponse possibles :

| Code | Signification |
|------|---------------|
| 200 | Liste récupérée avec succès |
| 500 | Erreur interne du serveur |

---

## 📦 5. Modèle de données (Entity : Users)

| Champ | Type | Description |
|-------|------|-------------|
| id | Long | Identifiant unique de l'utilisateur (auto-généré) |
| username | String | Nom d'utilisateur |
| email | String | Adresse e-mail utilisée pour l'envoi automatique |

Exemple de représentation JSON :
```json
{
  "id": 1,
  "username": "Jean Koffi",
  "email": "jean.koffi@example.com"
}
```

---

## ✉️ 6. Service Email — EmailService

### Rôle :
Assure l'envoi automatique des e-mails de bienvenue à chaque nouvel utilisateur enregistré.

### Méthode principale :
```java
public void welcomeMessage(String email, String username);
```

### Description :
- Envoie un e-mail à l'adresse fournie.
- Le contenu du message inclut une salutation personnalisée basée sur le username.

---

## 🧩 7. Documentation Swagger / OpenAPI

### ➤ Configuration (classe : OpenApiConfig.java)
```java
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Mail Automation API",
                version = "1.0",
                contact = @Contact(name = "by Modjo Victor", email = "yvankamsu88@gmail.com", url = "https://modjovictor.vercel.app"),
                description = "cette api permet d'envoi l'heure automatique aux utilisateur inscrits"
        )

)
public class OpenApiConfig {
}
```

### ➤ Accès à la documentation :

| Interface | URL |
|-----------|-----|
| Swagger UI | http://localhost:7777/swagger-ui.html |
| Spécification JSON (OpenAPI) | http://localhost:7777/api-docs |

---

## 🔒 8. Sécurité (optionnelle)

L'API peut être étendue avec une authentification par token (JWT) ou HTTP Basic pour protéger les endpoints.
À ce stade, les routes sont publiques pour faciliter les tests.

---

## 🧠 9. Bonnes pratiques d'utilisation

- Utiliser des adresses e-mail valides pour tester le service d'envoi automatique.
- Si tu veux une base persistante :
  ```properties
  spring.datasource.url=jdbc:h2:file:./data/maildb
  ```
- Ne pas oublier d'activer les App Passwords Gmail si tu utilises smtp.gmail.com.
- Documenter toute nouvelle méthode avec les annotations @Operation et @ApiResponse.

---

## 🚀 10. Exemple de test Swagger

Une fois ton application démarrée, accède à :
👉 http://localhost:8080/swagger-ui.html

Tu verras :
```
Mail Automation API
 ├── POST /api/users   → Créer un nouvel utilisateur (et envoyer un mail)
 └── GET /api/users    → Lister tous les utilisateurs
```

Chaque endpoint aura :
- Un formulaire interactif
- Une description claire
- Une réponse JSON détaillée

---

## 🧾 11. Version et maintenance

| Élément | Valeur |
|---------|--------|
| Version actuelle | 1.0.0 |
| Dernière mise à jour | 16 octobre 2025 |
| Langage principal | Java 17 |
| Framework | Spring Boot 3 |
| Auteur / Responsable | Victor Modjo |
| Contact support | [https://modjovictor.vercel.app/contact](https://modjovictor.vercel.app/contact) |

---

## 🧩 Licence

Ce projet est distribué sous licence MIT.
Vous êtes libre de le réutiliser, modifier et partager, à condition de conserver la mention d'auteur.

---

## 💡 Conclusion

Développé avec passion et pédagogie pour illustrer la création d'une API Spring Boot complète, documentée et automatisée.
