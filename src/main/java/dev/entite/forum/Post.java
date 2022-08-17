package dev.entite.forum;

import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Post extends BaseEntite {

    @Lob
    @Column(columnDefinition = "TEXT", length = 2048)
    private String content;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Topic topic;

    // Constructeur

    public Post() {
    }

    // Getter & Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
