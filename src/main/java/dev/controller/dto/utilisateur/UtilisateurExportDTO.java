package dev.controller.dto.utilisateur;

import dev.entite.Utilisateur;

/**
 *  DTO utilisé pour afficher les données de "Utilisateur" au FRONT <br/>
 *  Cette DTO est utilisé en place de UtilisateurAdminExport
 */
public class UtilisateurExportDTO {
    private Integer id;
    private String nom;
    private String prenom;

    // Constructor
    public UtilisateurExportDTO() {
    }

    public UtilisateurExportDTO(Utilisateur utilisateur) {
        this.id = utilisateur.getId();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
    }

    // Getter & Constructor
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

    @Override
    public String toString() {
        return "UtilisateurExportDTO{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
