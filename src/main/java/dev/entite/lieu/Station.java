package dev.entite.lieu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.entite.BaseEntite;
import dev.entite.Utilisateur;
import dev.entite.qualite.Polluant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des stations <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Station extends BaseEntite {
    /**
     * L'identifiant renvoyé par l'API Qualité d'air
     */
    private String idx;
    /**
     * Le nom de la station
     */
    private String nom;
    /**
     * Relation many to one avec les villes <br/>
     * Id dans table station = ville_id <br/>
     * Voir {@link dev.entite.lieu.Ville}
     */
    @ManyToOne
    @JoinColumn(name="ville_id")
    private Ville ville;
    /**
     * Relation many to many avec les polluants <br/>
     * Jointure bdd = station_polluant <br/>
     * Voir {@link dev.entite.qualite.Polluant}
     */
    @ManyToMany
    private List<Polluant> polluants = new ArrayList<>();
    /**
     * Relation many to many avec les utilisateurs <br/>
     * Jointure bdd = utilisateur_station <br/>
     * Voir {@link dev.entite.Utilisateur}
     */
    @ManyToMany(mappedBy = "stations")
    private List<Utilisateur> utilisateurs = new ArrayList<>();


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

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public List<dev.entite.Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<dev.entite.Utilisateur> utilisateur) {
        utilisateurs = utilisateur;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Station{");
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", ville=").append(ville);
        sb.append(", polluants=").append(polluants);
        sb.append('}');
        return sb.toString();
    }
}