package dev.exception.controller.dto;

import javax.validation.constraints.NotBlank;

/**
 * DTO de rubrique utilisé pour le changement de libelle
 */
public class RubriqueLibelleDTO {

    private Integer id;
    @NotBlank
    private String libelle;

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // toString
    @Override
    public String toString() {
        return "RubriqueLibelleDTO{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
