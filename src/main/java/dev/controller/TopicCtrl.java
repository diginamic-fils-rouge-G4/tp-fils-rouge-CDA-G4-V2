package dev.controller;

import dev.controller.dto.topic.TopicDTO;
import dev.controller.dto.topic.TopicModifDTO;
import dev.entite.forum.Topic;
import dev.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("topics")
public class TopicCtrl {
    private TopicService topicService;

    public TopicCtrl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTopics() {
        List<Topic> topics = topicService.findAll();
        if(!topics.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(topics);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun topic d'enregistré");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicDTO topicDTO) {
        Topic topic = topicService.create(topicDTO);
        return ResponseEntity.status(HttpStatus.OK).body(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Topic> topic = topicService.findById(id);
        if (topic.isPresent()) {
            topicService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping
    public Topic patch(@RequestBody TopicModifDTO modifDTO){
        return topicService.update(modifDTO);
    }

}
