package dev.repository;

import dev.entite.lieu.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    Departement findByNom(String nom);
}
