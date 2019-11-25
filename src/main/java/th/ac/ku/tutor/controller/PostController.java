package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.model.Post;
import th.ac.ku.tutor.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public Post postPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
