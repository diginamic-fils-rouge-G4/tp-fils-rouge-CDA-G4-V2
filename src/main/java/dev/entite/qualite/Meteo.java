package dev.entite.qualite;

import dev.entite.BaseEntite;
import dev.entite.lieu.Ville;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Meteo extends BaseEntite {

    private String mesure;
    private LocalDateTime date;
    private LocalDateTime heure;
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
