package dev.entite.forum;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour la définition des rubriques <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Rubrique extends BaseEntite {
    /**
     * Le titre de la rubrique
     */
    private String libelle;
    /**
     * Relation one to many avec les topics associés à une rubrique <br/>
     * Id dans table topic = rubrique_id <br/>
     * Voir {@link dev.entite.forum.Rubrique}
     */
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
