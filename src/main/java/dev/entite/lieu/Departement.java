package dev.entite.lieu;

import dev.entite.BaseEntite;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des départements <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Departement extends BaseEntite {
    /**
     * Le nom du département
     */
    private String nom;
    /**
     * Le code du département
     */
    private String code;
    /**
     * Relation one to many avec les villes associés à un département <br/>
     * Id dans table ville = departement_id <br/>
     * Voir {@link dev.entite.lieu.Ville}
     */
    @OneToMany(mappedBy = "departement")
    private List<Ville> villes = new ArrayList<>();
    /**
     * Relation many to one avec les régions <br/>
     * Id dans table departement = region_id <br/>
     * Voir {@link dev.entite.lieu.Region}
     */
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
