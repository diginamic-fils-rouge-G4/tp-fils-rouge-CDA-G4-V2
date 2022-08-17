package dev.repository;

import dev.entite.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, Integer> {
}
