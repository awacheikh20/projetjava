import java.util.ArrayList;

public class Livre {

    // Attributs
    private String titre;
    private String auteur;
    private int anneePublication;
    private String isbn;
    private boolean estEmprunte;

    // Constructeur
    public Livre(String titre, String auteur, int anneePublication, String isbn, boolean estEmprunte) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.isbn = isbn;
        this.estEmprunte = estEmprunte;
    }

    // Méthodes
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getIsbn() {
        
        return this.isbn;
    }

    
    

    // Getter et setter pour l'état d'emprunt du livre
    public boolean isEmprunte() {
        return estEmprunte;
    }

    public void setEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }

    
}
