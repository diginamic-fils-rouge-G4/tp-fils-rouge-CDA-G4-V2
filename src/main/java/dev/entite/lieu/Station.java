package dev.entite.lieu;

import dev.entite.BaseEntite;
import dev.entite.qualite.Polluant;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends BaseEntite {

    private String nom;
    @ManyToOne
    private Ville ville;
    @ManyToMany
    private List<Station> stationList = new ArrayList<>();

    // Constructeur
    public Station() {
    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
