package dev.entite.qualite;

import dev.entite.BaseEntite;
import dev.entite.lieu.Ville;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des données météo <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Meteo extends BaseEntite {
    /**
     * La mesure des données météo
     */
    private String mesure;
    /**
     * La date des données météo
     */
    private LocalDateTime date;
    /**
     * L'heure des données météo
     */
    private LocalDateTime heure;
    /**
     * Relation many to many avec les villes <br/>
     * Jointure bdd = meteo_villes <br/>
     * Voir {@link dev.entite.lieu.Ville}
     */
    @ManyToMany
    private List<Ville> villes = new ArrayList<>();

    // Constructeur
    public Meteo() {
    }

    // Getter & Setter
    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
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

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
