package dev.controller.dto.rubrique;

import javax.validation.constraints.NotBlank;

/**
 *  DTO utilisé pour la création de "Rubrique"
 */
public class RubriqueDTO {
    @NotBlank
    private String libelle;

    // Constructor
    public RubriqueDTO() {
    }

    // Getter & Setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
