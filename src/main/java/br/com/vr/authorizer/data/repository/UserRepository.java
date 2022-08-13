package br.com.vr.authorizer.data.repository;

import br.com.vr.authorizer.domain.User;
import br.com.vr.authorizer.domain.dto.UserDataDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    UserDataDTO findByEmail(String email);
}
