package dev.entite;

import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilisateur extends BaseEntite {

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(unique = true, nullable = false)
    private String mail;
    @Column(nullable = false)
    private int role;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "utilisateur")
    private List<Favoris> stationFavoris = new ArrayList<>();
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Favoris> getStationFavoris() {
        return stationFavoris;
    }

    public void setStationFavoris(List<Favoris> stationFavoris) {
        this.stationFavoris = stationFavoris;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

}
