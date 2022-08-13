package br.com.vr.authorizer.data.service;

import br.com.vr.authorizer.domain.dto.UserDataDTO;

import java.util.Optional;

public interface UserService {
    Optional<UserDataDTO> findByEmail(String email);
}
