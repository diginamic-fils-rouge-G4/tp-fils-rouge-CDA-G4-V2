package dev.controller.dto;

public class UtilisateurRoleDTO {
    private Integer id;
    private String role;

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

    public UtilisateurRoleDTO() {
    }

    @Override
    public String toString() {
        return "UtilisateurRoleDTO{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
