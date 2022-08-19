package dev.controller.dto.utilisateur;

// Objet reçu par le front
public class UtilisateurExportDTO {
    private String nom;
    private String prenom;
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
    public UtilisateurExportDTO() {
    }
    @Override
    public String toString() {
        return "UtilisateurExportDTO{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
