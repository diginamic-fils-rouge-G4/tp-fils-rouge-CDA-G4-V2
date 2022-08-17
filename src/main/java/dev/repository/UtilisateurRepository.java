package dev.repository;
import dev.entite.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findByMail(String mail);

    Optional<Utilisateur> findByNom(String nom);
}
