package br.com.vr.authorizer.infra.adapter.repository;

import br.com.vr.authorizer.infra.adapter.entity.colections.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
