package dev.entite.lieu;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Departement extends BaseEntite {

    private String nom;
    private String code;
    @OneToMany(mappedBy = "departement")
    private List<Ville> villes = new ArrayList<>();
    @ManyToOne
    private Region region;

    // Constructeur
    public Departement() {
    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Departement{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", villes=").append(villes);
        sb.append(", region=").append(region);
        sb.append('}');
        return sb.toString();
    }
}
