package dev.entite.lieu;

import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ville extends BaseEntite {

    private String codePostal;
    private String nom;
    private Integer population;
    @ManyToOne
    private Departement departement;
    @OneToMany(mappedBy = "ville")
    private List<Station> stations = new ArrayList<>();
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
