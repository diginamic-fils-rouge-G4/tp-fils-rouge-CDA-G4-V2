package dev.entite.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.*;
/**
 * Classe pour la définition des posts <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Post extends BaseEntite {

    /**
     * Le contenu du post
     * Lob permet de changer le String "content" de simple "varchar" en "longtext",
     * columnDefinition permet de le changer en "text" <br/>
     */
    @Lob
    @Column(columnDefinition = "TEXT", length = 2048)
    private String content;
    /**
     * Relation many to one avec les utilisateurs <br/>
     * Id dans table post = utilisateur_id<br/>
     * Voir {@link dev.entite.Utilisateur}
     */
    @ManyToOne
    private Utilisateur utilisateur;
    /**
     * Relation many to one avec les topics<br/>
     * Id dans table post = topic_id <br/>
     * Voir {@link dev.entite.forum.Topic}
     */
    @ManyToOne(cascade = {CascadeType.ALL})
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
