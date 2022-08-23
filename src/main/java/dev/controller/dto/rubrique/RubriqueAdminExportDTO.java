package dev.controller.dto.rubrique;

/**
 * DTO utilisé pour afficher les données de "Rubrique" au FRONT au niveau du Dashboard, <br/>
 * actuellement RubriqueExportDTO est utilisé à la place
 */
public class RubriqueAdminExportDTO {

    // Libelle de la rubrique
    private String libelle;

    // Constructor
    public RubriqueAdminExportDTO() {
    }

    // Getter & Setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
