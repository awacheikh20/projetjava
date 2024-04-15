//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque();
        int choix=0;
        do {
            afficherMenuPrincipal();
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour chariot

            switch (choix) {
                case 1: // Gestion des livres
                    ajouterLivre(scanner, bibliotheque);
                    break;
                case 2: // Gestion des utilisateurs
                   rechercherLivre(scanner, bibliotheque);
                    break;
                case 3: // Gestion des emprunts
                    enregistrerEmprunt(scanner, bibliotheque);
                    break;
                case 4: enregistrerRetour(scanner, bibliotheque);
                    break;
        
                case 5: // Quitter
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 4);
        scanner.close(); 
    
    }

    private static void gererEmprunts(Bibliotheque bibliotheque, Scanner scanner) {
        enregistrerEmprunt(scanner, bibliotheque);
    }
    
  
    
    private static void gererLivres(Bibliotheque bibliotheque, Scanner scanner) {
        ajouterLivre(scanner, bibliotheque);
        rechercherLivre(scanner, bibliotheque);
        supprimerLivre(bibliotheque, scanner);
    }

    // Méthode pour afficher le menu principal
    public static void afficherMenuPrincipal() {
           System.out.println("Bienvenue dans le systéme de gestion de Bibliothéque\n"); 
           System.out.println("╔═══════════════════════════ Menu Principal ═══════════════════════════╗"); 
           System.out.println("║ 1. Ajouter un livre ║"); 
           System.out.println("║ 2. Rechercher un livre ║"); 
           System.out.println("║ 3. Enregistrer un emprunt ║");
           System.out.println("║ 4. Enregistrer un retour ║"); 
           System.out.println("║ 5. Quitter ║"); 
           System.out.println("╚══════════════════════════════════════════════════════════════════════╝"); 
           System.out.print("Choix : ");
    }


    public static void ajouterLivre(Scanner scanner, Bibliotheque bibliotheque) { 
        System.out.println("╔════════════════════ Ajouter un Livre ═════════════════════╗"); 
          System.out.print("║ Titre du livre : "); 
          String titre = scanner.nextLine(); 
          System.out.print("║ Auteur du livre : "); 
          String auteur = scanner.nextLine(); 
          System.out.print("║ Année de publication : "); 
          int annee = scanner.nextInt(); 
          scanner.nextLine(); 
          System.out.print("║ ISBN : "); 
          String isbn = scanner.nextLine();
          boolean estEmprunter = false; 
          Livre livre = new Livre(titre, auteur, annee, isbn, estEmprunter); 
          bibliotheque.ajouterLivre(livre); 
        System.out.println("║ Livre ajouté avec succès !"); 
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }



    public static void rechercherLivre(Scanner scanner, Bibliotheque bibliotheque) { 
                System.out.println("╔═══════════════════ Rechercher un Livre ════════════════════╗"); 
                  System.out.print("║ Entrez le titre, l'auteur ou l'ISBN du livre à rechercher : ");
                  String recherche = scanner.nextLine();
                    bibliotheque.rechercherLivre(recherche);
                System.out.println("╚════════════════════════════════════════════════════════════╝");
    } 



    public static void enregistrerEmprunt(Scanner scanner, Bibliotheque bibliotheque) { 
        System.out.println("╔══════════════════ Enregistrer un Emprunt ═══════════════════╗");
          System.out.print("║ Entrez votre nom : ");
          String nomUtilisateur = scanner.nextLine();
           Utilisateur utilisateur = new Utilisateur(nomUtilisateur, nomUtilisateur, 0); 
          System.out.print("║ Entrez le titre, l'auteur ou l'ISBN du livre à emprunter : "); 
           String recherche = scanner.nextLine();
           bibliotheque.rechercherLivre(recherche);
           Livre livre = new Livre(recherche, nomUtilisateur, 0, recherche, false);
            if (recherche != null) { if (bibliotheque.verifierEligibilite(utilisateur))
                 { bibliotheque.enregistrerEmprunt(utilisateur, livre); 
                    System.out.println("║ Emprunt enregistré avec succès !");
                 }
                  else { System.out.println("║ Vous avez déjà emprunté 3 livres. Impossible d'emprunter plus."); 
                } 
            } else { System.out.println("║ Aucun livre trouvé avec ce titre, cet auteur ou cet ISBN."); 
        }
         System.out.println("╚════════════════════════════════════════════════════════════╝"); 
    }





    public static void enregistrerRetour(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.println("╔══════════════════ Enregistrer un Retour ════════════════════╗"); 
          System.out.print("║ Entrez votre nom : "); String nomUtilisateur = scanner.nextLine();
         Utilisateur utilisateur = new Utilisateur(nomUtilisateur, nomUtilisateur, 0); 
          System.out.print("║ Entrez le titre, l'auteur ou l'ISBN du livre à retourner : ");
          String recherche = scanner.nextLine();
          bibliotheque.rechercherLivre(recherche); 
          Livre livre = new Livre(recherche, nomUtilisateur, 0, recherche, false);
           if (recherche != null) { bibliotheque.enregistrerRetour(utilisateur, livre);
                System.out.println("║ Retour enregistré avec succès !"); 
               } 
               else { System.out.println("║ Aucun livre trouvé avec ce titre, cet auteur ou cet ISBN."); 
           }
         System.out.println("╚════════════════════════════════════════════════════════════╝");
    }




    public static void supprimerLivre(Bibliotheque bibliotheque, Scanner scanner) {
        System.out.print("Saisissez le titre ou l'ISBN du livre à supprimer : ");
        String recherche = scanner.nextLine();

    
         Livre supL = new Livre(recherche, "", 0, "", false);
        if (recherche != null) {
            bibliotheque.supprimerLivre(supL);
            System.out.println("Le livre a été supprimé avec succès.");
        } else {
            System.out.println("Aucun livre trouvé avec cette recherche.");
        }
    }



}
