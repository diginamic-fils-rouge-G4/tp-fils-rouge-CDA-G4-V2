package dev.controller;

import dev.controller.dto.PostDTO;
import dev.entite.forum.Post;
import dev.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping
    public void delete(@RequestBody Integer id) {
        postService.delete(id);
    }
}
