package th.ac.ku.tutor.repository;

import org.springframework.data.repository.CrudRepository;
import th.ac.ku.tutor.model.Token;

public interface TokenRepository extends CrudRepository<Token, String> {
    Token findByToken(String token);
}
