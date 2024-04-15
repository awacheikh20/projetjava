import java.util.ArrayList;

public class Utilisateur {

    // Attributs
    private String nom;
    private String prenom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes;
    private boolean cotisationAjour; // Indique si l'utilisateur est à jour de ses cotisations

    // Constructeur
    public Utilisateur(String prenom, String nom, int numeroIdentification) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
        this.cotisationAjour = true; // Par défaut, l'utilisateur est considéré comme à jour
    }

   
    public void emprunterLivre(Livre livre) {
        if (isCotisationAjour()) {
            livresEmpruntes.add(livre);
            System.out.println("L'utilisateur " + prenom +" " + nom + " a emprunté le livre " + livre.getTitre());
        } else {
            System.out.println("L'utilisateur " + prenom +" "+ nom + " ne peut pas emprunter de livres car ses cotisations ne sont pas à jour.");
        }
    }

    //La méthode retournerLivre() vérifie si le livre passé en paramètre est emprunté par l'utilisateur. Si oui, elle le retire de la liste des livres empruntés et affiche un message de confirmation. Sinon, elle informe l'utilisateur que le livre n'est pas emprunté.    
    public void retournerLivre(Livre livre) {
        if (livresEmpruntes.contains(livre)) {
            livresEmpruntes.remove(livre);
            System.out.println("L'utilisateur "+ prenom +" " + nom +" a retourné le livre " + livre.getTitre());
        } else {
            System.out.println("L'utilisateur "+ prenom +" " + nom +" n'a pas emprunté le livre " + livre.getTitre());
        }
    }

    //La méthode afficherLivresEmpruntes() affiche les titres des livres empruntés par l'utilisateur, ou indique s'il n'a emprunté aucun livre.
    public void afficherLivresEmpruntes() {
        if (livresEmpruntes.isEmpty()) {
            System.out.println("L'utilisateur " + prenom +" " + nom + " n'a pas de livres empruntés.");
        } else {
            System.out.println("Livres empruntés par "+ prenom +" " + nom +" :");
            for (Livre livre : livresEmpruntes) {
                System.out.println("- " + livre.getTitre());
            }
        }
    }

    // Getteurs et Setteurs
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

     public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(int numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public ArrayList<Livre> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes) {
        this.livresEmpruntes = livresEmpruntes;
    }

    public boolean isCotisationAjour() {
        return cotisationAjour;
    }

    public void setCotisationAjour(boolean cotisationAjour) {
        this.cotisationAjour = cotisationAjour;
    }
}



