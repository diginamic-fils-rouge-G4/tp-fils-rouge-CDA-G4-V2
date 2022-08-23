package dev.controller.dto.rubrique;

import dev.entite.BaseEntite;
import dev.entite.forum.Rubrique;

import java.util.List;

/**
 *  DTO utilisé pour afficher les données de "Rubrique" au FRONT <br/>
 *  Cette DTO est utilisé en place de RubriqueAdminExport
 */
public class RubriqueExportDTO {
    private Integer id;

    // Libelle de la rubrique
    private String libelle;

    // Nombre de topic présent dans la rubrique
    private Integer nbreTopics;

    // Constructor
    public RubriqueExportDTO() {
    }

    public RubriqueExportDTO(Rubrique rubrique) {
        this.id = rubrique.getId();
        this.libelle = rubrique.getLibelle();
        this.nbreTopics = rubrique.getTopics().size();
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
