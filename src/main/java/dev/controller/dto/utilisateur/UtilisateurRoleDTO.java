package dev.controller.dto.utilisateur;

/**
 * DTO d'utilisateur utilisé pour changer le rôle d'un utilisateur
 */
public class UtilisateurRoleDTO {
    private Integer id;
    private String role;

    // Constructor
    public UtilisateurRoleDTO() {
    }

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "UtilisateurRoleDTO{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
