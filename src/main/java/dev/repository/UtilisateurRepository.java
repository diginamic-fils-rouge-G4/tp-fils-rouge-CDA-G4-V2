package dev.repository;
import dev.entite.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * Interface pour les méthodes en lien avec la table utilisateur
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    /**
     * Recherche un utilisateur en fonction de son email <br/>
     * @param mail de l'utilisateur <br/>
     * @return un Optional d'un {@link dev.entite.Utilisateur}
     */
    Optional<Utilisateur> findByMail(String mail);
    /**
     * Recherche un utilisateur en fonction de son nom <br/>
     * @param nom de l'utilisateur <br/>
     * @return un Optional d'un {@link dev.entite.Utilisateur}
     */
    Optional<Utilisateur> findByNom(String nom);
}
