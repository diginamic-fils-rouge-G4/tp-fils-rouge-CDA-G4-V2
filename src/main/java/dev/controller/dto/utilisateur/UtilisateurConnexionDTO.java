package dev.controller.dto.utilisateur;

/**
 * DTO d'utilisateur utilisé pour la connexion d'un utilisateur
 */
public class UtilisateurConnexionDTO {
    String email;
    String password;

    // Constructor
    public UtilisateurConnexionDTO() {
    }

    // Getter & Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "utilisateurConnexionDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
