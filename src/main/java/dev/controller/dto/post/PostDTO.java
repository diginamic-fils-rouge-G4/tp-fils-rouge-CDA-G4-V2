package dev.controller.dto.post;

import javax.validation.constraints.NotBlank;

public class PostDTO {
    @NotBlank
    private String content;
    @NotBlank
    private String utilisateur;
    @NotBlank
    private String topic;

    public PostDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
