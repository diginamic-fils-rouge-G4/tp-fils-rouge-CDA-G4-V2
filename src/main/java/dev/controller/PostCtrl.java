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

/**
 *  Controller utilisé pour la gestion des Posts <br/>
 *  Utilise le service : {@link dev.service.PostService}
 */
@CrossOrigin
@RestController
@RequestMapping("posts")
public class PostCtrl {
    private PostService postService;

    public PostCtrl(PostService postService) {
        this.postService = postService;
    }

    /**
     * Récupère la totalité des posts
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        List<PostExportDTO> posts = postService.findAll().stream().map(PostExportDTO::new).toList();
        if(posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun POST enregistré");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        }
    }

    /**
     * Créé un POST
     * @param postDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDTO postDTO) {
        postService.create(postDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Message envoyé");
    }

    /**
     * Supprime un POST à partir de son id
     * @param id
     * @return
     */
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
