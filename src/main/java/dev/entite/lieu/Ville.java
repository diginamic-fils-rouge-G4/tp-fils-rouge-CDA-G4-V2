package dev.entite.lieu;

import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des villes <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Ville extends BaseEntite {
    /**
     * Le code postal de la ville
     */
    private String codePostal;
    /**
     * Le nom de la ville
     */
    private String nom;
    /**
     * La population de la ville
     */
    private Integer population;
    /**
     * Relation many to one avec les departements <br/>
     * Id dans table ville = departement_id <br/>
     * Voir {@link dev.entite.lieu.Departement}
     */
    @ManyToOne
    private Departement departement;
    /**
     * Relation one to many avec les stations associés à une ville <br/>
     * Id dans table station = ville_id <br/>
     * Voir {@link dev.entite.lieu.Station}
     */
    @OneToMany(mappedBy = "ville")
    private List<Station> stations = new ArrayList<>();
    /**
     * Relation one to many avec les utilisateurs associés à une ville <br/>
     * Id dans table utilisateur = ville_id <br/>
     * Voir {@link dev.entite.Utilisateur}
     */
    @OneToMany(mappedBy = "ville")
    private List<Utilisateur> utilisateurs = new ArrayList<>();

    // Constructeur
    public Ville() {
    }

    // Getter & Setter
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
