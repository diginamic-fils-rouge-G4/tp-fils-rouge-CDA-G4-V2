package dev.service;

import dev.controller.dto.TopicDTO;
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

    public TopicService(TopicRepository topicRepository, RubriqueService rubriqueService) {
        this.topicRepository = topicRepository;
        this.rubriqueService = rubriqueService;
    }

    public Topic create(@Valid TopicDTO topicDTO) {
        List<String> errMsg = new ArrayList<>();
        Optional<Rubrique> rubrique = rubriqueService.findByLibelle(topicDTO.getRubrique());

        if(rubrique.isEmpty()) {
            errMsg.add("La rubrique " + topicDTO.getRubrique() + " n'existe pas");
        }

        if(!errMsg.isEmpty()) {
            throw new CreateException(errMsg);
        }

        Topic topic = new Topic();
        topic.setLibelle(topicDTO.getLibelle());
        topic.setRubrique(rubrique.get());
        return topicRepository.save(topic);
    }
}
