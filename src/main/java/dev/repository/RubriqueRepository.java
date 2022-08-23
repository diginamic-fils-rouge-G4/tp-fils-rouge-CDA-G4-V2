package dev.repository;

import dev.entite.forum.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Interface pour les méthodes en lien avec la table rubrique
 */
@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Integer> {
    /**
     * Recherche une rubrique en fonction de son nom <br/>
     * @param libelle de la rubrique <br/>
     * @return un Optional d'un {@link dev.entite.forum.Rubrique}
     */
    Optional<Rubrique> findByLibelle(String libelle);


}
