package dev.repository;

import dev.entite.lieu.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Interface pour les méthodes en lien avec la table ville
 */
@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    /**
     * Recherche une ville en fonction de son nom <br/>
     * @param nom de la ville <br/>
     * @return une {@link dev.entite.lieu.Ville}
     */
    Ville findByNom(String nom);
}
