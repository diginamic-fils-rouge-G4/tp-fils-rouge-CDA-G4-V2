package dev.controller.dto.topic;

import javax.validation.constraints.NotBlank;

public class TopicDTO {
    @NotBlank
    private String libelle;
    @NotBlank
    private String utilisateur;
    @NotBlank
    private Integer rubrique;

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

    public Integer getRubrique() {
        return rubrique;
    }

    public void setRubrique(Integer rubrique) {
        this.rubrique = rubrique;
    }
}
