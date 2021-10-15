# TD 1
## Remarques préliminaires
* Pour l'ensemble des TDs, vous créerez un compte individuel sur [github](https://github.com/).
  Vous nommerez ce compte de la façon suivante: `uvsq<MonNuméroÉtudiant>`.
  Par exemple, pour un étudiant de numéro *21601234*, le compte sera `uvsq21601234`.
* Les commandes `git` sont à taper en ligne de commande dans un *shell*.
* Vous pouvez utiliser l'IDE de votre choix.
  Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants
* Vous déposerez une archive contenant l'ensemble de votre travail sur Moodle.

## Partie en présentiel : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions**.
À chaque étape, consultez le statut des fichiers du projet ainsi que l'historique.

1. Sur la forge, créez le projet Java `SimpleFraction`;
   En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
   > Cocher une (ou plusieurs) des cases *Initialize this repository with* est l'équivalent d'ajouter les fichiers et paramètres de licence au projet créé dans le dépôt distant de la forge. Après cette action on aura automatiquement un **commit initial**. Cette action remplace donc les commandes **git add** et **git commit**. Par contre lorsqu'on n'en coche aucune de ces cases on n'aura pas de **commit initial**

   Pour la suite, ne cochez aucune de ces cases.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`);
    ```bash
    git config --global user.email "sarah.tasga1@gmail.com"
    git config --global user.name "uvsq22107541"
    ```
1. Initialisez le dépôt `git` local pour le projet;
    ```bash
    git init SimpleFraction
    ```
1. Créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet;
   Vérifiez que le projet compile et s'exécute dans l'IDE;
   Validez les changements;
    ```bash
    git add Fraction.java
    git commit -m "Ajout de la classe Fraction.java"
    git add Main.java
    git commit -m "Ajout de la classe Main.java"
    ```
1. Ajoutez un constructeur et la méthode `toString` à la classe `Fraction` et modifiez la classe `Main` en conséquence;
   Validez les changements;
    ```Java
    //La classe Fraction

    public class Fraction {

      private int numerateur;
      private int denominateur;

      public Fraction(int numerateur,int denominateur) {
          this.numerateur=numerateur;
          this.denominateur=denominateur;
      }

      @Override
      public String toString() {
          return numerateur + "/" + denominateur;
      }
    
      @Test
      public void testdenominateur(){
          assertNotEquals(this.denominateur,0);
      }
    }

    //La classe Main 

    public class Main {
      public static void main(String[] args) {
          //Essayer la fraction 10/0 (dans ce cas --> une exception car denominateur=0)
          Fraction f = new Fraction(10,0);
          System.out.println(" La Fraction : "+ f.toString());
          f.testdenominateur();
      }
    }

    

    ```
1. Publiez vos modifications sur le dépôt distant;
   Vous utiliserez le protocole `https` pour cela;
   Vérifiez avec le navigateur;
    ```bash
    git commit -a -m "Modification des classes Fraction.java et Main.java" 
    git remote add origin https://github.com/uvsq22107541/SimpleFraction.git
    git push --set-upstream origin master

    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
   Quelle syntaxe est utilisée pour ce fichier ?
   > La synthaxe utilisée pour le fichier de documentation 'README.md' ajouté sur la forge est markdown (.md). En effet, ce fichier est un fichier écrit avec le programme de langage Markdown qui est en fait un langage de balisage simple conçu dans le but de formater du texte sue le Web à l’aide d’une grammaire de formatage de texte simple.
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull origin master
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (fichier `.gitignore`);
    ```bash
    echo "out" > .gitignore
    git add .gitignore
    git commit -m "Ajout du fichier .gitignore (contenant les fichiers de compilation)"
    ```
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    ## Considérons que les fichiers de configurations ont deja ete envoyés sur le dépot distant
    git rm -r *.iml
    git rm -r .idea
    git commit -m "Retrait des fichiers de configuration de l'IDE de projet"
    ```
   Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    echo -e "*.iml \n.idea/" >> .gitignore
    git commit -a -m " Modification du fichier .gitignore --> Ajout des fichiers de configuration "
    git push --set-upstream origin master
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    * Explication de la procédure de façon synthétique
   > Pour mettre en place un protocole clé SSH, il faut créer une paire de clé publique/privée. En effet la clé publique se trouve sur la forge tandis que la clé privée est sauvegardée sur ordinateur (local).
   La forge utilise la paire de clés pour l'authentification. Ainsi, cette procédure empêche toute modification du projet par une personne tiers. Les étapes pour réaliser cette procédure :
    * Générer une clé SSH, en entrant la commande :
    ```bash
    ssh-keygen -t ed25519 -C "sarah.tasga1@gmail.com"
    ```
    * Copier la clé publique obtenue et la conserver dans un fichier .pub dans les paramètres de la forge.
    * Tester l'association de la clé à la forge dans le cas de l'utilisation du site github.com, en entrant la commande :
    ```bash
    ssh -T git@github.com
    ```
    * Ajouter ensuite la branche sur le dossier de projet local, en entrant la commande :
    ```bash
    git remote add origin_ssh git@github.com:uvsq21107541/SimpleFraction.git
    ```

## Partie II (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, ...).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, ...).

1. Quel OS et quel shell de commande utilisez-vous ?
   > J'utilise l'OS WINDOWS et le PowerShell.
1. Quelle commande permet d'obtenir de l'aide ?
   Donnez un exemple.
    ```bash
    help 
    help mkdir    
    ```