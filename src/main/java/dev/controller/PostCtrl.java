package dev.controller;

import dev.controller.dto.PostDTO;
import dev.entite.forum.Post;
import dev.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("post")
public class PostCtrl {
    private PostService postService;

    public PostCtrl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping
    public PostDTO create(@RequestBody PostDTO postDTO) {
        Post post = postService.create(postDTO);
        PostDTO newPostDTO = new PostDTO();
        newPostDTO.setContent(post.getContent());
        newPostDTO.setUtilisateur(post.getUtilisateur().getMail());
        newPostDTO.setTopic(post.getTopic().getLibelle());
        return newPostDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Post> post = postService.findById(id);
        if(post.isPresent()) {
            postService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
