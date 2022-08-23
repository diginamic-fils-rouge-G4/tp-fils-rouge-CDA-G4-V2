package dev.repository;

import dev.entite.forum.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface pour les méthodes en lien avec la table topic
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
