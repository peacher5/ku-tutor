package th.ac.ku.tutor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import th.ac.ku.tutor.model.Post;
import th.ac.ku.tutor.service.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    @InjectMocks
    Post post;

    @Mock
    PostService postService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        ArrayList<Post> list = new ArrayList<Post>();
        Post post1 = new Post();
        post1.setId("1");
        post1.setTitle("รับสอน python");
        post1.setDescription("สอนวันจันทร์-ศุกร์ 17.00-18.00น.");
        post1.setContent("สอนพื้นฐานทั้งหมด");
        post1.setCoverPictureUrl("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500");
        list.add(post1);

        Post post2 = new Post();
        post2.setId("2");
        post2.setTitle("รับสอนภาษาC");
        post2.setDescription("สอนวันจันทร์ 17.00-18.00น.");
        post2.setContent("สอนพื้นฐานทั้งหมด");
        post2.setCoverPictureUrl("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500");
        list.add(post2);

        when(postService.getPost()).thenReturn(list);
//        when(postService.getPostById("2")).thenReturn(post2);
        when(postService.getPostById("1")).thenReturn(post1);
    }

    @Test
    public void getAllPostTest() {
        List<Post> listTmp = postService.getPost();
        assertEquals(2, listTmp.size());
    }

    @Test
    public void getPostByIdTest() {
        Post post = postService.getPostById("1");
        assertEquals("รับสอน python", post.getTitle());
        assertEquals("สอนวันจันทร์-ศุกร์ 17.00-18.00น.", post.getDescription());
        assertEquals("สอนพื้นฐานทั้งหมด", post.getContent());
        assertEquals("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500", post.getCoverPictureUrl());
    }

    @Test
    public void createPostIdTest() {
        Post post = new Post();
        post.setId("3");
        post.setTitle("รับสอนภาษาC++");
        post.setDescription("สอนวันจันทร์-พุธ 17.00-18.00น.");
        post.setContent("สอนพื้นฐานทั้งหมด");
        post.setCoverPictureUrl("https://lh3.googleusercontent.com/a-/AAuE7mAj5i8HgJMrgjUhAfKc6p7TqvCqTl_NeeGBw0cy=s500");
        postService.createPost(post);
        verify(postService, times(1)).createPost(post);
    }
}
