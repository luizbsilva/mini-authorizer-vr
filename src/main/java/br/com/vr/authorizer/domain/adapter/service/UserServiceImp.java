package br.com.vr.authorizer.domain.adapter.service;

import br.com.vr.authorizer.domain.UserPort;
import br.com.vr.authorizer.domain.dto.UserDataDTO;
import br.com.vr.authorizer.domain.port.adapter.UserServicePort;
import br.com.vr.authorizer.domain.port.repository.UserRepositoryPort;

import java.util.Optional;

public class UserServiceImp implements UserServicePort {
    private UserRepositoryPort repository;

    public UserServiceImp(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserDataDTO> findByEmail(String email) {
        UserPort user = repository.findByEmail(email);
        return Optional.ofNullable(user.toUser());
    }
}
