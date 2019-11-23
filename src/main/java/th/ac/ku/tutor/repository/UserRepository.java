package th.ac.ku.tutor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ac.ku.tutor.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
