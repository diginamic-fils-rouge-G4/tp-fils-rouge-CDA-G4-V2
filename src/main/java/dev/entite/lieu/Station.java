package dev.entite.lieu;

import dev.entite.BaseEntite;
import dev.entite.Favoris;
import dev.entite.qualite.Polluant;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends BaseEntite {

    private String nom;
    @ManyToOne
    private Ville ville;
    @ManyToMany
    private List<Polluant> polluants = new ArrayList<>();

    @OneToMany(mappedBy = "station")
    private List<Favoris> favoris = new ArrayList<>();

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

    public List<Polluant> getPolluants() {
        return polluants;
    }

    public void setPolluants(List<Polluant> polluants) {
        this.polluants = polluants;
    }

    public List<Favoris> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Favoris> favoris) {
        this.favoris = favoris;
    }
}
