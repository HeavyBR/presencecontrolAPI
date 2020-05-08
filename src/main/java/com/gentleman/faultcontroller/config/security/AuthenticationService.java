package com.gentleman.faultcontroller.config.security;

import com.gentleman.faultcontroller.domain.User;
import com.gentleman.faultcontroller.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> usuario = repository.findByEmail(s);
        if(usuario.isPresent()) return usuario.get();

        throw new UsernameNotFoundException("Dados inválidos");
    }

}
