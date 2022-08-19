package dev.controller.dto.post;

import java.time.LocalDateTime;

// DTO utilisé pour les informations affichées au FRONT
public class PostExportDTO {

    // Nom de l'utilisateur qui effectué le post
    String utilisateur;

    // Contenue du post
    String content;

    // Date du post
    LocalDateTime date;

    // Heure du post
    LocalDateTime heure;

    // Getter & Setter
    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }
}
