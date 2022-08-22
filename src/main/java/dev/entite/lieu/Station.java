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

@Entity
public class Station extends BaseEntite {

    private String idx;
    private String nom;
    @ManyToOne
    @JoinColumn(name="ville_id")
    private Ville ville;
    @ManyToMany
    private List<Polluant> polluants = new ArrayList<>();

    @ManyToMany(mappedBy = "stations")
    @JsonIgnore
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