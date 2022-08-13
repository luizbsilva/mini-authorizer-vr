package br.com.vr.authorizer.data.security.services;

import br.com.vr.authorizer.data.security.JwtUserFactory;
import br.com.vr.authorizer.data.service.UserService;
import br.com.vr.authorizer.domain.dto.UserDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDataDTO> userData = service.findByEmail(username);

        if (userData.isPresent()) {
            return JwtUserFactory.create(userData.get());
        }

        throw new UsernameNotFoundException("Email não encontrado.");
    }

}
