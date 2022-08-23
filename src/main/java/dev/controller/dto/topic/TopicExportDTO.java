package dev.controller.dto.topic;

import dev.controller.dto.post.PostExportDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.forum.Topic;

import javax.validation.constraints.NotBlank;

// Objet reçu par le front
public class TopicExportDTO {
    @NotBlank
    private Integer id;
    @NotBlank
    private String libelle;
    @NotBlank
    private UtilisateurExportDTO utilisateur;
    @NotBlank
    private PostExportDTO post;

    public TopicExportDTO() {
    }
    public TopicExportDTO(Topic topic) {
        this.id = topic.getId();
        this.libelle = topic.getLibelle();
        this.utilisateur = new UtilisateurExportDTO(topic.getUtilisateur());
        this.post = new PostExportDTO(topic.getPosts().get(topic.getPosts().size()-1));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public UtilisateurExportDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurExportDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    public PostExportDTO getPost() {
        return post;
    }

    public void setPost(PostExportDTO post) {
        this.post = post;
    }
}
