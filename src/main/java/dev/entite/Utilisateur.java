package dev.entite;

import dev.entite.lieu.Station;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
    @ManyToMany
    private List<Station> stationFavoris = new ArrayList<>();

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

    public List<Station> getStationFavoris() {
        return stationFavoris;
    }

    public void setStationFavoris(List<Station> stationFavoris) {
        this.stationFavoris = stationFavoris;
    }

    // toString
    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
