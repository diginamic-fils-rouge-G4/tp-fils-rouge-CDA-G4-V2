package dev.controller.dto.station;

import dev.entite.lieu.Ville;
import dev.entite.qualite.Polluant;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class StationDTO {

    private String idx;
    private String nom;

    public StationDTO() {
    }
    public String getIdx() {
        return idx;
    }
    public void setIdx(String idx) {
        this.idx = idx;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

}
