package dev.entite.lieu;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des régions <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Region extends BaseEntite {
    /**
     * Le nom de la région
     */
    private String nom;
    /**
     * Relation one to many avec les départements associés à une région <br/>
     * Id dans table departement = region_id <br/>
     * Voir {@link dev.entite.lieu.Departement}
     */
    @OneToMany(mappedBy = "region")
    private List<Departement> departements = new ArrayList<>();

    // Constructeur
    public Region() {
    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }
}
