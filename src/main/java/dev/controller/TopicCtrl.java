package dev.controller;

import dev.controller.dto.TopicDTO;
import dev.entite.forum.Topic;
import dev.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("topics")
public class TopicCtrl {
    private TopicService topicService;

    public TopicCtrl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    // A FAIRE. Utilisé un ResponseEntity
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @PostMapping
    // A FAIRE. Utilisé un ResponseEntity
    public Topic create(@RequestBody TopicDTO topicDTO) {
        Topic topic = topicService.create(topicDTO);
        Topic newTopicDTO = new Topic();
        newTopicDTO.setLibelle(topic.getLibelle());
        newTopicDTO.setRubrique(topic.getRubrique());
        newTopicDTO.setUtilisateur(topic.getUtilisateur());
        //Créer un topic dto pour la création et pour la réponse et enlever le json ignore
        return newTopicDTO;
    }
    @DeleteMapping("/{id}")
    // A FAIRE. Utilisé un ResponseEntity
    public void delete(@PathVariable int id ){
        topicService.delete(id);
    }
    @PatchMapping("/{id}")
    // A FAIRE. Utilisé un ResponseEntity
    public void patch(@RequestBody int i){

    }

}
