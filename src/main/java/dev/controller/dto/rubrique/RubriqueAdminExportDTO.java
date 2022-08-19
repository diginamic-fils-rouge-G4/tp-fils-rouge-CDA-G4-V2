package dev.controller.dto.rubrique;

// DTO utilisé pour les informations affichées au FRONT (au niveau du Dashboard)
public class RubriqueAdminExportDTO {

    // Libelle de la rubrique
    private String libelle;

    // Getter & Setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
