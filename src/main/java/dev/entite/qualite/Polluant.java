package dev.entite.qualite;

import dev.entite.BaseEntite;
import dev.entite.lieu.Station;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des données des polluants <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Polluant extends BaseEntite {
    /**
     * La mesure qualité des données polluants
     */
    private String qualite;
    /**
     * Le type de polluant
     */
    private String type;
    /**
     * La date des données polluants
     */
    private LocalDateTime date;
    /**
     * L'heure des données météo
     */
    private LocalDateTime heure;

    // Constructeur
    public Polluant() {
    }

    // Getter & Setter
    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getHeure() {
        return heure;
    }

    public void setHeure(LocalDateTime heure) {
        this.heure = heure;
    }
}
