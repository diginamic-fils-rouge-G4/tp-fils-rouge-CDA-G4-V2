package dev.repository;

import dev.entite.lieu.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findByNom(String nom);
}
