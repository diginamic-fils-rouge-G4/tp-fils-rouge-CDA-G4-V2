package dev.repository;

import dev.entite.lieu.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    Station findByNom(String nom);
}
