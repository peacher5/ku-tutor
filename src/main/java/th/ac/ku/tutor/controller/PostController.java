package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.model.Post;
import th.ac.ku.tutor.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post postPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> findAllPost() {
        return postService.getPost();
    }

    @GetMapping
    public Optional<Post> findPostById(@RequestParam String id) {
        return postService.getPostById(id);
    }
}
