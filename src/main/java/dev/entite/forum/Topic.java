package dev.entite.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des topics <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Topic extends BaseEntite {
    /**
     * Le titre du topic
     */
    private String libelle;
    /**
     * Relation many to one avec les utilisateurs <br/>
     * Id dans table topic = utilisateur_id <br/>
     * Voir {@link dev.entite.Utilisateur}
     */
    @ManyToOne
    private Utilisateur utilisateur;
    /**
     * Relation one to many avec les posts associés à un topic <br/>
     * Id dans table post = topic_id <br/>
     * Voir {@link dev.entite.forum.Post}
     */
    @OneToMany(mappedBy = "topic", cascade = {CascadeType.ALL})
    private List<Post> posts = new ArrayList<>();
    /**
     * Relation many to one avec les rubrique <br/>
     * Id dans table topic = rubrique_id <br/>
     * Voir {@link dev.entite.forum.Rubrique}
     */
    @ManyToOne
    private Rubrique rubrique;

    // Constructeur
    public Topic() {
    }

    // Getter & Setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }
}
