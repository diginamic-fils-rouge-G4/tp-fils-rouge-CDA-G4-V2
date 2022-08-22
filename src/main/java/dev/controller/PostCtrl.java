package dev.controller;

import dev.controller.dto.post.PostDTO;
import dev.controller.dto.post.PostExportDTO;
import dev.entite.forum.Post;
import dev.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("posts")
public class PostCtrl {
    private PostService postService;

    public PostCtrl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        List<PostExportDTO> posts = postService.findAll().stream().map(PostExportDTO::new).toList();
        if(posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun POST enregistré dans ce TOPIC");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDTO postDTO) {
        postService.create(postDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Message envoyé");
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
