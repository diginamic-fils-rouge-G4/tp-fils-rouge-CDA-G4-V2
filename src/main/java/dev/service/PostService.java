package dev.service;

import dev.controller.dto.post.PostDTO;
import dev.entite.Utilisateur;
import dev.entite.forum.Post;
import dev.entite.forum.Topic;
import dev.exception.CreateException;
import dev.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UtilisateurService utilisateurService;
    private TopicService topicService;

    public PostService(PostRepository postRepository, UtilisateurService utilisateurService, TopicService topicService) {
        this.postRepository = postRepository;
        this.utilisateurService = utilisateurService;
        this.topicService = topicService;
    }

    public Post create(@Valid PostDTO postDTO) {
        List<String> errMsg = new ArrayList<>();
        Optional<Topic> topic = topicService.findById(Integer.parseInt(postDTO.getTopic()));

        if(topic.isEmpty()) {
            errMsg.add("Le topic " + topicService.findById(Integer.parseInt(postDTO.getTopic())) + " n'existe pas");
        }

        Optional<Utilisateur> utilisateur = utilisateurService.getByid(Integer.parseInt(postDTO.getUtilisateur()));

        if(utilisateur.isEmpty()) {
            errMsg.add("L'utilisateur " + utilisateurService.getByid(Integer.parseInt(postDTO.getUtilisateur())) + " n'existe pas");
        }

        if(!errMsg.isEmpty()) {
            throw new CreateException(errMsg);
        }

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setUtilisateur(utilisateur.get());
        post.setTopic(topic.get());
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public void delete(Integer id) {
        Optional<Post> post = findById(id);
        Post postToDelete = new Post();
        postToDelete.setTopic(post.get().getTopic());
        postToDelete.setUtilisateur(post.get().getUtilisateur());
        postToDelete.setContent(post.get().getContent());
        postToDelete.setId(post.get().getId());
        postRepository.delete(postToDelete);
    }
}
