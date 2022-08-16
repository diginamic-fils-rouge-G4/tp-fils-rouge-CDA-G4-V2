package dev.entite.forum;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rubrique extends BaseEntite {

    private String libelle;
    @OneToMany(mappedBy = "rubrique")
    private List<Topic> topics = new ArrayList<>();

    // Constructeur
    public Rubrique() {
    }

    // Getter & Setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
