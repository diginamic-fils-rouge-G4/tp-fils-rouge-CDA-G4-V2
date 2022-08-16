package dev.entite.lieu;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Region extends BaseEntite {

    private String nom;
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
