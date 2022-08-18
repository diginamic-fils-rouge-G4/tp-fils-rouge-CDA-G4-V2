package dev.service;

import dev.exception.controller.dto.TopicDTO;
import dev.entite.Utilisateur;
import dev.entite.forum.Rubrique;
import dev.entite.forum.Topic;
import dev.exception.CreateException;
import dev.repository.TopicRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private TopicRepository topicRepository;
    private RubriqueService rubriqueService;

    private UtilisateurService utilisateurService;

    public TopicService(TopicRepository topicRepository, RubriqueService rubriqueService, UtilisateurService utilisateurService) {
        this.topicRepository = topicRepository;
        this.rubriqueService = rubriqueService;
        this.utilisateurService = utilisateurService;
    }

    public Topic create(@Valid TopicDTO topicDTO) {
        List<String> errMsg = new ArrayList<>();
        Optional<Rubrique> rubrique = rubriqueService.getByid(Integer.parseInt(topicDTO.getIdRubrique()));

        if(rubrique.isEmpty()) {
            errMsg.add("La rubrique " + topicDTO.getIdRubrique() + " n'existe pas");
        }

        Optional<Utilisateur> utilisateur = utilisateurService.getByMail(topicDTO.getUtilisateur());

        if(utilisateur.isEmpty()) {
            errMsg.add("L'utilisateur " + topicDTO.getUtilisateur() + " n'existe pas");
        }

        System.out.println(errMsg);

        if(!errMsg.isEmpty()) {
            throw new CreateException(errMsg);
        }

        Topic topic = new Topic();
        topic.setLibelle(topicDTO.getLibelle());
        topic.setRubrique(rubrique.get());
        topic.setUtilisateur(utilisateur.get());
        return topicRepository.save(topic);
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
    public Optional<Topic> findById(int id){
        return topicRepository.findById(id);
    }
    public void delete(int id){
        topicRepository.delete(findById(id).get());
    }
}
