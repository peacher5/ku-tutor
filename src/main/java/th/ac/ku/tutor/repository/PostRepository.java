package th.ac.ku.tutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ac.ku.tutor.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {


}
