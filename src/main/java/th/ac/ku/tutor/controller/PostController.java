package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.model.Post;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post postPost(@RequestBody Post post, @RequestAttribute User user) {
        post.setOwnerId(user.getId());
        return postService.createPost(post);
    }

    @GetMapping
    public List<Post> findAllPost() {
        return postService.getPost();
    }

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable String id) {
        return postService.getPostById(id);
    }

    @DeleteMapping
    public boolean deletePostById(@RequestParam String id) {
        postService.deletePostById(id);
        return true;
    }
}
