package dev.controller.dto.utilisateur;

import dev.entite.Utilisateur;

// Objet reçu par le front
public class UtilisateurExportDTO {
    private Integer id;
    private String nom;
    private String prenom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
    public UtilisateurExportDTO(Utilisateur utilisateur) {
        this.id = utilisateur.getId();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
    }
    @Override
    public String toString() {
        return "UtilisateurExportDTO{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
