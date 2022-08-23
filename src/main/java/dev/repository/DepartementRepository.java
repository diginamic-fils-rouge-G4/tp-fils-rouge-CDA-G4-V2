package dev.repository;

import dev.entite.lieu.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface pour les méthodes en lien avec la table departement
 */
@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    /**
     * Recherche un département en fonction de son nom <br/>
     * @param nom du département <br/>
     * @return un {@link dev.entite.lieu.Departement}
     */
    Departement findByNom(String nom);
}
