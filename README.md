# tp-fils-rouge-CDA-G4-backend
## Login / Signin
![image](https://user-images.githubusercontent.com/44068884/184831949-088e19bc-378f-4027-b929-9354f4d1f5c5.png)
- [X] POST /login
```
{
  status : 201,
  body : {"email" : "...", "motDePasse" : "..."},
  header : token
}
```
## Signup
![image](https://user-images.githubusercontent.com/44068884/184831992-7fe59173-5845-4a30-8e82-1923e1a7b32e.png)
- [X] POST /signup
```
{
  status : 201,
  body : {"nom" : "...", "prenom" : "...", "ville" : "...", "codePostal" : "...", "email" : "...", "motDePasse" : "..."}
}
```
## Map

![image](https://user-images.githubusercontent.com/44068884/184832427-e527a2b6-3a8a-4850-a284-d1dacde6d6d9.png)

- [ ] GET /map/favories/{user}/favorie
- [ ] GET /map/favories
Recevoir la liste des favories de l'utilisateur (user).
```
{
  status : 200,
  body : {"listeStation" : [...]}
}
```
- [ ] POST /map/favorie
Envoyer un nouveau favorie de l'utilisateur.
```
{
  status : 201,
  body : {"nom_station" : "..."}
}
```
- [ ] DELETE /map/favorie
Retirer un favorie de l'utilisateur.
```
{
  status : 204
}
```
## Forum
### Rubrique
![image](https://user-images.githubusercontent.com/44068884/184851837-ff9dc027-077a-4cf4-8217-c8481092d0bd.png)
- [ ] GET /rubrique
Recevoir la liste des rubriques du forum.
```
{
  status : 200,
  body : {"listeRubrique" : [...]}
}
```
- [ ] POST /rubrique
Ajouté une rubrique.
```
{
  status : 201,
  body : {"nomRubrique" : "..."}
}
```
- [ ] DELETE /rubrique
Supprimer une rubrique.
```
{
  status : 204
}
```
### Topic
![image](https://user-images.githubusercontent.com/44068884/184851889-691e7add-af31-4832-b305-f720cb03f0c0.png)
- [ ] GET /topic
Recevoir la liste des topics de la rubrique.
```
{
  status : 200,
  body : {"listeTopic" : [...]}
}
```
- [ ] POST /topic
Ajouté un topic.
```
{
  status : 201,
  body : {"nom_topic" : "..."}
}
```
- [ ] DELETE /topic
Supprimer un topic.
```
{
  status : 204
}
```
### Post
![image](https://user-images.githubusercontent.com/44068884/184852047-2f44b85d-1d85-4d8e-9761-f52f681d6933.png)
- [ ] GET /post
Recevoir la liste des posts du topic.
```
{
  status : 200,
  body : {"listePost" : [...]}
}
```
- [ ] POST /post
Ajouté un post.
```
{
  status : 201,
  body : {"user_id" : "...", "content" : {"sitation": post_id, "body":"..."}, "date" : "...", "heure" : "..."}
}
```
- [ ] DELETE /post
Supprimer un post.
```
{
  status : 204
}
```
## Dashboard
Gestion pour les administrateurs des utilisateurs (User) et des rubriques des forums (Rubrique).
### User
![image](https://user-images.githubusercontent.com/44068884/184852169-8f8051cc-8c51-4ec1-92de-5f74e450efed.png)
- [X] GET /utilisateur/all
Affiche la liste des utilisateurs (users).
```
{
  status : 200,
  body : {"listeUtilisateur" : [...]}
}
```
- [X] GET /utilisateur/all/{page}
Affiche la liste des utilisateurs (users) en liste de 30.
```
{
  status : 200,
  body : {"listeUtilisateur" : [...]}
}
```
- [X] PATCH /utilisateur
Change le rôle d'un utilisateur.
```
{
  status : 201,
  body : {"id" : "...", "role" : "..."}
}
```
- [x] DELETE /utilisateur/{id}
Supprime un utilisateur.
```
{
  status : 204
}
```
### Rubrique
![image](https://user-images.githubusercontent.com/44068884/184852115-893617d5-45dc-4ecc-980e-30e64cc8903a.png)
- [ ] GET /admin/dashboard/rubrique
Affiche la liste des rubriques (rubrique).
```
{
  status : 200,
  body : {"listeRubrique" : [...]}
}
```
- [ ] PATCH /admin/dashboard/rubrique/changerubrique
Change le nom d'une rubrique.
```
{
  status : 201,
  body : {"nom_rubrique" : "...", "nouveauNom" : "..."}
}
```
- [ ] DELETE /admin/dashboard/rubrique/deleterubrique
Supprime une rubrique.
```
{
  status : 204
}
```
