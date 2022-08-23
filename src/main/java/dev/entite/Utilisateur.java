package dev.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour la définition des utilisateurs <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Utilisateur extends BaseEntite {
    /**
     * Le nom de l'utilisateur
     */
    @Column(nullable = false)
    private String nom;
    /**
     * Le prénom de l'utilisateur
     */
    @Column(nullable = false)
    private String prenom;
    /**
     * L'adresse mail de l'utilisateur
     */
    @Column(unique = true, nullable = false)
    private String mail;
    /**
     * Le rôle de l'utilisateur
     */
    @Column(nullable = false)
    private String role;
    /**
     * Le mot de passe de l'utilisateur
     */
    @Column(nullable = false)
    private String password;
    /**
     * Relation many to many avec les stations <br/>
     * Jointure bdd = utilisateur_station <br/>
     * Voir {@link dev.entite.lieu.Station}
     */
    @ManyToMany
    @JoinTable(
            name = "utilisateur_station",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "station_id"))
    private List<Station> stations = new ArrayList<>();
    /**
     * Relation many to one avec les villes <br/>
     * Id dans table utilisateur = ville_id <br/>
     * Voir {@link dev.entite.lieu.Ville}
     */
    @ManyToOne
    private Ville ville;

    // Constructeur
    public Utilisateur() {
    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
