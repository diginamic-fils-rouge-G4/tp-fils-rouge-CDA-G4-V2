package dev.entite.forum;

import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic extends BaseEntite {

    private String libelle;
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "topic")
    private List<Post> posts = new ArrayList<>();
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
