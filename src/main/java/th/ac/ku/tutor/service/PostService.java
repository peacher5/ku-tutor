package th.ac.ku.tutor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.tutor.model.Post;
import th.ac.ku.tutor.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPost() { return postRepository.findAll(); }

    public Optional<Post> getPostById(String id) { return postRepository.findById(id); }

    public boolean deletePostById(String id) {
        postRepository.deleteById(id);
        return true;
    }

}
