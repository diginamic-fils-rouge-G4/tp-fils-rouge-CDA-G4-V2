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
    public void delete(@PathVariable int id ){
        topicService.delete(id);
    }
    @PatchMapping("/{id}")
    public void patch(@RequestBody int i){

    }

}
