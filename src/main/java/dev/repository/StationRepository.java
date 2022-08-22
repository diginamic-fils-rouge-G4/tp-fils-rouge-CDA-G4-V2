package dev.repository;

import dev.entite.lieu.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    Station findByNom(String nom);

    Station findByIdx(String id);
    @Query("SELECT s FROM Station s join Utilisateur u WHERE s.idx = :id and u.mail = :email")
    Station findByIdxAAndUtilisateurEmail(String id , String email);

}
