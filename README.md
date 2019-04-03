# Tourizm

## Développement

### Lancement de l'application en local

#### Prérequis
Une instance PostgreSQL sur [```http://localhost:5432/```]() avec :
* Une Base de donnés ```tourizm```

* Un utilisateur ```postgres``` dont le mot de passe est ```tourizm```

#### Procédure
Créer une configuration Spring Boot classique, dont la classe principal est ```TourizmApplication``` et utilisant une JDK 8 
JDK 8

**Tourizm** utilise Liquibase, les tables sont créés au lancementde l'application.

L'application est ensuite disponible sur [```http://localhost:8080/```]()
