package dev.exception.controller.dto;

import dev.entite.lieu.Ville;
import dev.entite.qualite.Polluant;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class StationDTO {

    private String nom;

    private Ville ville;

    private List<Polluant> polluants = new ArrayList<>();

    public StationDTO(String nom, Ville ville, List<Polluant> polluants) {
        this.nom = nom;
        this.ville = ville;
        this.polluants = polluants;
    }

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
}
