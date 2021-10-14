#Réponses aux questions du TD1

#PARTIE_1
#Sur la forge, une fois crée le dépôt (_repository_) 'SimpleFraction'
#En terme de *commits*, la différence qu'on constate entre cocher une (ou plusieurs)
#des cases *Initialize this repository with* et n'en cocher aucune est que
dans le premier cas on a automatiquement un commit initial (faire un pull puis commit), 
par contre dans le deuxieme cas on aura pas de commit initial (faire un commit) a partir 
de la ligne de commande cmd.

#configuration`git` avec votre nom (`user.name`) et votre email (`user.email`)
git config --global user.email "sarah.tasga1@gmail.com"
git config --global user.name "uvsq22107541"

#Initialisation le dépôt `git` local pour le projet
git init

#Créeation de la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple 
#affichage) dans le projet; 
#Vérification que le projet compile et s'exécute dans l'IDE;
#Validation les changements;
# Commandes pour valider les changements
git add .
git commit -m "Validation des changements"

#Ajout d'un constructeur et la méthode `toString` à la classe `Fraction` et modification de  
#la classe `Main` en conséquence; Validation les changements;

#java
public class Main {
public static void main(String[] args) {
Fraction f = new Fraction(10,0);
f.testdenominateur();
    }
}
#bash 
git commit -m "Validation des changements"

#Publication des modifications sur le dépôt distant; utilisation du protocole `https` pour cela;
#Vérification avec le navigateur;
git remote add origin https://github.com/uvsq22107541/SimpleFraction.git
git push --set-upstream origin master
(génération d'un token pour le push)

#Sur la forge (SimpleFraction), ajout d'un fichier de documentation `README.md`.
#La syntaxe utilisée pour ce fichier est :
touch README.md

#Récupération local des modifications effectuées sur la forge
git add README.md
git status
git commit -m "Ajout du fichier README"

#Copier ici le contenu de `.gitignore`
#Ajout des répertoires et fichiers issus de la compilation aux fichiers ignorés par
# `git` (fichier `.gitignore`);

# Copier ici le contenu de `.gitignore`
/out

#Retrait  des fichiers de configuration de l'IDE du projet;
#Ajout des fichiers de configuration aux fichiers ignorés par `git`.

# Copier ici les modifications de `.gitignore`
/out
/.idea

#Configuration de l'accès par clé publique/clé privée à la forge
(cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
#Expliquez la procédure de façon synthétique

Aller a : settings --> Developer setting --> Personal Access Token --> Generate new token
         --> Generate token 
          puis copier le token généré par github et le coller à la place du mot de passe
          (la fenetre qui apparait a la derniere commande "push")

#PARTIE_2



