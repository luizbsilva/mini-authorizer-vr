package br.com.vr.authorizer.domain.port.adapter;

import br.com.vr.authorizer.domain.dto.UserDataDTO;

import java.util.Optional;

public interface UserServicePort {

    Optional<UserDataDTO> findByEmail(String email);
}
