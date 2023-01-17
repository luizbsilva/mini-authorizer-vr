package br.com.vr.authorizer.infra.security.services;

import br.com.vr.authorizer.domain.dto.UserDataDTO;
import br.com.vr.authorizer.domain.port.adapter.UserServicePort;
import br.com.vr.authorizer.infra.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServicePort service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDataDTO> userData = service.findByEmail(username);

        if (userData.isPresent()) {
            return JwtUserFactory.create(userData.get());
        }

        throw new UsernameNotFoundException("Email não encontrado.");
    }

}
