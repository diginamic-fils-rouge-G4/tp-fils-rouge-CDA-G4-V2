package dev.controller.dto;

import javax.validation.constraints.NotBlank;

public class TopicDTO {
    @NotBlank
    private String libelle;
    @NotBlank
    private String utilisateur;
    @NotBlank
    private String rubrique;

    public TopicDTO() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }
}
