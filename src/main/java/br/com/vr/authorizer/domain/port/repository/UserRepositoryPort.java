package br.com.vr.authorizer.domain.port.repository;

import br.com.vr.authorizer.domain.UserPort;

public interface UserRepositoryPort {
    UserPort findByEmail(String email);
}
