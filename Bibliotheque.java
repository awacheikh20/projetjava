import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;
    private ArrayList<Emprunt> emprunts; // Liste d'Emprunt

    // Constructeur
    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
        this.emprunts = new ArrayList<>(); // Initialisation de la liste d'Emprunt
    }
    

    public void ajouterLivre(Livre livre) {
        if (!listeLivres.contains(livre)) { // Vérifier si le livre n'existe pas déjà
            listeLivres.add(livre);
            System.out.println("Livre ajouté avec succès : " + livre);
        } else {
            System.out.println("Ce livre existe déjà dans la bibliothèque.");
        }
    }
    
    public void rechercherLivre(String critere) {
        boolean recherche = false;
        for (Livre livre : listeLivres) {
            // Vérifie si le titre, l'auteur ou l'ISBN du livre contient la chaîne de recherche
            if (livre.getTitre().contains(critere) || livre.getAuteur().contains(critere) || livre.getIsbn().contains(critere)) {
                System.out.println("Livre trouvé : " + livre);
                recherche = true;
            }
        }
        if (!recherche) {
            System.out.println("Aucun livre trouvé avec ce critère de recherche.");
        }
    }
    
    public void supprimerLivre(Livre livre) {
        if (listeLivres.contains(livre)) { // Vérifier si le livre existe dans la liste
            listeLivres.remove(livre);
            System.out.println("Livre supprimé avec succès : " + livre);
        } else {
            System.out.println("Ce livre n'existe pas dans la bibliothèque.");
        }
    }
    
    public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
        String nom = utilisateur.getNom();
        emprunterLivre(nom, livre, utilisateur);
        System.out.println("Emprunt enregistré avec succès : " + livre + " par " + utilisateur);
    }
    
    public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
        String nom = utilisateur.getNom();
        retournerLivre(nom, livre);
        System.out.println("Retour enregistré avec succès : " + livre + " par " + utilisateur);
    }

     // Méthode pour emprunter un livre par un utilisateur
     public void emprunterLivre(String nomUtilisateur, Livre livre, Utilisateur utilisateur) {
        // Vérifier si le livre est disponible
        if (!livre.isEmprunte()) {
            // Marquer le livre comme emprunté
            livre.setEmprunte(true);

            // Ajouter l'emprunt à la liste d'emprunts
            Emprunt nouvelEmprunt = new Emprunt(utilisateur, livre);
            emprunts.add(nouvelEmprunt);

            System.out.println("L'emprunt du livre '" + livre.getTitre() + "' par " + nomUtilisateur + " a été enregistré.");
        } else {
            System.out.println("Le livre '" + livre.getTitre() + "' n'est pas disponible pour l'emprunt.");
        }
    }

    // Méthode pour retourner un livre emprunté par un utilisateur
    public void retournerLivre(String nomUtilisateur, Livre livre) {
        // Vérifier si le livre est emprunté par l'utilisateur
        boolean livreEmprunteParUtilisateur = false;
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getUtilisateur().equals(nomUtilisateur) && emprunt.getLivre().equals(livre)) {
                livreEmprunteParUtilisateur = true;
                break;
            }
        }

        if (livreEmprunteParUtilisateur) {
            // Marquer le livre comme retourné
            livre.setEmprunte(false);

            // Supprimer l'emprunt de la liste d'emprunts
            emprunts.removeIf(emprunt -> emprunt.getUtilisateur().equals(nomUtilisateur) && emprunt.getLivre().equals(livre));

            System.out.println("Le livre '" + livre.getTitre() + "' a été retourné avec succès par " + nomUtilisateur + ".");
        } else {
            System.out.println("Le livre '" + livre.getTitre() + "' n'est pas emprunté par " + nomUtilisateur + ".");
        }
    }

    public boolean verifierEligibilite(Utilisateur utilisateur) {
        int nombreEmprunts = 0;
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getUtilisateur().equals(utilisateur)) {
                nombreEmprunts++;
            }
        }
        return nombreEmprunts < 3;
    }

}
    



