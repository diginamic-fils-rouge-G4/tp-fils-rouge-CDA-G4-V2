package dev.repository;

import dev.entite.forum.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Integer> {
    Optional<Rubrique> findByLibelle(String libelle);


}
