package dev.entite;

import dev.entite.lieu.Station;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Favoris extends BaseEntite {
    private String nom;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Station station;

    public Favoris() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Favoris{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", utilisateur=").append(utilisateur);
        sb.append(", station=").append(station);
        sb.append('}');
        return sb.toString();
    }
}
