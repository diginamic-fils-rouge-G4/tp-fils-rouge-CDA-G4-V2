package dev.controller.dto.topic;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicDTO topicDTO = (TopicDTO) o;
        return Objects.equals(libelle, topicDTO.libelle) && Objects.equals(utilisateur, topicDTO.utilisateur) && Objects.equals(rubrique, topicDTO.rubrique);
    }
    @Override
    public int hashCode() {
        return Objects.hash(libelle, utilisateur, rubrique);
    }
}

