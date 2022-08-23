package dev.repository;

import dev.entite.lieu.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Interface pour les méthodes en lien avec la table station
 */
@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
    /**
     * Recherche une station en fonction de son nom <br/>
     * @param nom de la station <br/>
     * @return une {@link dev.entite.lieu.Station}
     */
    Station findByNom(String nom);
    /**
     * Recherche une station en fonction de son nom <br/>
     * @param id de la station <br/>
     * @return une {@link dev.entite.lieu.Station}
     */
    Station findByIdx(String id);
    /**
     * Recherche une station en fonction de l'utilisateur qui est connecté <br/>
     * @param id de la station, email de l'utilisateur <br/>
     * @return une {@link dev.entite.lieu.Station}
     */
    @Query("SELECT s FROM Station s join Utilisateur u WHERE s.idx = :id and u.mail = :email")
    Station findByIdxAAndUtilisateurEmail(String id , String email);

    @Query("SELECT s FROM Station s where s.utilisateurs.size > 0")
    List<Station> FindActiveStation();

}
