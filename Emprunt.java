public class Emprunt {
    private Utilisateur utilisateur;
    private Livre livre;

    // Constructeur
    public Emprunt(Utilisateur utilisateur, Livre livre) {
        this.utilisateur = utilisateur;
        this.livre = livre;
    }

    // Getters
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Livre getLivre() {
        return livre;
    }
     // Méthode pour retourner le livre emprunté
     public void retournerLivre() {
        // Marquer le livre comme disponible
        livre.setEmprunte(false);
    }

    // Méthode pour emprunter un livre
    public void emprunterLivre() {
        // Marquer le livre comme emprunté
        livre.setEmprunte(true);
    }

    

}
