package dev.controller.dto.rubrique;

// DTO utilisé pour les informations affichées au FRONT
public class RubriqueExportDTO {

    // Libelle de la rubrique
    private String libelle;

    // Nombre de topic présent dans la rubrique
    private Integer nbreTopics;

    // Constructor
    public RubriqueExportDTO() {
    }

    // Getter & Setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNbreTopics() {
        return nbreTopics;
    }

    public void setNbreTopics(Integer nbreTopics) {
        this.nbreTopics = nbreTopics;
    }
}
