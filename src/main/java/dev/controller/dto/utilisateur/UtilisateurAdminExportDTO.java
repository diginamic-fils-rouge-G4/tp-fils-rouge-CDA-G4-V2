package dev.controller.dto.utilisateur;

import dev.entite.Utilisateur;

/**
 * DTO utilisé pour afficher les données de "Utilisateur" au FRONT au niveau du Dashboard, <br/>
 * actuellement UtilisateurExportDTO est utilisé à la place
 */
public class UtilisateurAdminExportDTO extends UtilisateurExportDTO{

   private String Role;

   // Constructor
    public UtilisateurAdminExportDTO(String role) {
        Role = role;
    }

    public UtilisateurAdminExportDTO(Utilisateur utilisateur) {
        super(utilisateur);
        Role = utilisateur.getRole();
    }

    public UtilisateurAdminExportDTO(){
        super();
    }

    // Getter & Setter
    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
