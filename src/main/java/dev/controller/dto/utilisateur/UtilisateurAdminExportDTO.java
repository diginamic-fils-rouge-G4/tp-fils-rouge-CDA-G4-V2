package dev.controller.dto.utilisateur;

// Objet reçu par le front
public class UtilisateurAdminExportDTO {

    // Nom de l'utilisateur
    private String nom;

    // Prenom de l'utilisateur
    private String prenom;

    // Role de l'utilisateur
    private String role;

    // Constructor
    public UtilisateurAdminExportDTO() {
    }

    // Getter & Setter
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
