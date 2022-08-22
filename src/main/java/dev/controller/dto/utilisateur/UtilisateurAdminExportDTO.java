package dev.controller.dto.utilisateur;

import dev.entite.Utilisateur;

// Objet reçu par le front
public class UtilisateurAdminExportDTO extends UtilisateurExportDTO{

   private String Role;

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

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
