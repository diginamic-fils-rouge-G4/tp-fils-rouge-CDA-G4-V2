package dev.controller.dto.rubrique;

import javax.validation.constraints.NotBlank;

public class RubriqueDTO {
    @NotBlank
    private String libelle;

    public RubriqueDTO() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
