package dev.controller.dto.post;

import dev.controller.dto.topic.TopicExportDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.forum.Post;

import java.time.LocalDateTime;

// DTO utilisé pour les informations affichées au FRONT
public class PostExportDTO {

    // Nom de l'utilisateur qui effectué le post
    private UtilisateurExportDTO utilisateur;

    private Integer id;

    // Contenue du post
    private String content;

    // Constructor
    public PostExportDTO() {
    }

    public PostExportDTO(Post post) {
        this.id = post.getId();
        this.utilisateur = new UtilisateurExportDTO(post.getUtilisateur());
        this.content = post.getContent();
    }

    // Getter & Setter
    public UtilisateurExportDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurExportDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
