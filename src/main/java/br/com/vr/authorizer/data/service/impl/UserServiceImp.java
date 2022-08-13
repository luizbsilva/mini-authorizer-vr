package br.com.vr.authorizer.data.service.impl;

import br.com.vr.authorizer.data.repository.UserRepository;
import br.com.vr.authorizer.data.service.UserService;
import br.com.vr.authorizer.domain.dto.UserDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;


    @Override
    public Optional<UserDataDTO> findByEmail(String email) {
        return Optional.ofNullable(repository.findByEmail(email));
    }
}
