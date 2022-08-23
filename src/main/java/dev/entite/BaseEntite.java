package dev.entite;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe abstraite pour les identifiants générés automatiquement
 */
@MappedSuperclass
public abstract class BaseEntite {

    /**
     * L'identifiant généré automatiquement
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
