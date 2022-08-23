package dev.repository;

import dev.entite.lieu.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface pour les méthodes en lien avec la table region
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    /**
     * Recherche une région en fonction de son nom <br/>
     * @param nom de la région <br/>
     * @return une {@link dev.entite.lieu.Region}
     */
    Region findByNom(String nom);
}
