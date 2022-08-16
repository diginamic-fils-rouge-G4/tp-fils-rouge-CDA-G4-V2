package dev.entite.forum;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rubrique extends BaseEntite {

    private String libelle;
    @OneToMany
    private List<Topic> topicList = new ArrayList<>();

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

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
