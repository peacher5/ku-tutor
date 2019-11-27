package th.ac.ku.tutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.tutor.model.Post;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.PostService;
import th.ac.ku.tutor.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    private UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity postPost(@RequestBody Post post, @RequestAttribute User user) {
        post.setOwnerId(user.getId());
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity findAllPost() {
        List<Object> response = new ArrayList<>();

        for (Post post : postService.getPost()) {
            HashMap<Object, Object> postResponse = new HashMap<>();

            postResponse.put("id", post.getId());
            postResponse.put("title", post.getTitle());
            postResponse.put("description", post.getDescription());
            postResponse.put("content", post.getContent());
            postResponse.put("coverPictureUrl", post.getCoverPictureUrl());

            User user = userService.getUserById(post.getOwnerId());
            postResponse.put("user", user);
            response.add(postResponse);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity findPostById(@PathVariable String id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @DeleteMapping
    public ResponseEntity deletePostById(@RequestParam String id) {
        return ResponseEntity.ok(postService.deletePostById(id));
    }
}
