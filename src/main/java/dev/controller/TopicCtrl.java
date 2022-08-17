package dev.controller;

import dev.controller.dto.TopicDTO;
import dev.entite.forum.Topic;
import dev.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("topic")
public class TopicCtrl {
    private TopicService topicService;

    public TopicCtrl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @PostMapping
    public TopicDTO create(@RequestBody TopicDTO topicDTO) {
        Topic topic = topicService.create(topicDTO);
        TopicDTO newTopicDTO = new TopicDTO();
        newTopicDTO.setLibelle(topic.getLibelle());
        newTopicDTO.setRubrique(topic.getRubrique().getLibelle());
        newTopicDTO.setUtilisateur(topic.getUtilisateur().getMail());
        //Créer un topic dto pour la création et pour la réponse et enlever le json ignore
        return newTopicDTO;
    }
}
