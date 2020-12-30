# Présentation

Cette application s'appelle Dog knowledge et utilise anglais. Elle contient une page de Login, une page d'inscription et une page qui s'affiche une liste de chien, cette liste contient leurs races, leurs photos et leurs pays d'origine. Lorsqu'on appuie un élément de liste, il s'affichera les informations détail de chien.

# Consignes Respectées

Architecture MVVM

Clean Architecture

Utilisation d’une réelle BDD

Appel Api REST

Affichage d’une liste

Tests Unitaires

Design la page de Login et la page d'inscription


# Fonctionnalités

## Logo APP :

<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/paw.png" width="10%" height="10%">

## Page de Login : 

- La page de login :
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Login.jpg" width="25%" height="25%">

- Lorsque je suis trombe adresse e-mail ou mon mot de passe, il s'affichera login échoué : 
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Login_failed.jpg" width="25%" height="25%">

- Lorsque j'appuie la touche de sortie 2 fois en 1 second, c'est-à-dire que je quitte cette application.
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Exit_app.jpg" width="25%" height="25%">

## Page d'inscription : 

- Si je n'ai pas de compte, je dois aller sur la page d'inscription en cliqant le bouton Register de la page login.
Ceci est la page d'inscription : 
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Registration.jpg" width="25%" height="25%">

- Si le mot de passe saisi sur la page d'inscription est très court (< 6 caractères), il vous demandera de ressaisir le nouveau mot de passe.
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Registration_failed_password.jpg" width="25%" height="25%">

- Si l'adresse mail existe déjà, il vous demandera de ressaisir le nouveau adresse et le nouveau mot de passe.
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Registration_failed.jpg" width="25%" height="25%">

## Page liste : 

- Affichage d'une liste de chien : 
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/List.jpg" width="25%" height="25%">

- Lorsqu'on appuie un élément de liste, il s'affichera les informations détail de ce chien. Par example : 
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/List_detailInfo.jpg" width="25%" height="25%">

- Elle est actualisable
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/List_refresh.jpg" width="25%" height="25%">

- Si je coupe le réseau et fait alors refresh de liste, il s'affichera Api erreur, mais les données de listes existent quand même.
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/List_refresh_failed.jpg" width="25%" height="25%">

- Lorsque j'appuie la touche de sortie, il vous demandera de vérifier la sortie de cette page. 
Si je confirme quitter cette page et voudrais encore aller à la page de liste, il faudra ressaisir le login et le mot de passe.
<img src="https://github.com/Houyu0926/Houyu_app/blob/master/App_images/Exit_list.jpg" width="25%" height="25%">
