package br.com.pitang.carsapi.user.framework.output.hibernate;

import br.com.pitang.carsapi.shared.domain.exception.UsuarioSenhaInvalidosException;
import br.com.pitang.carsapi.user.framework.output.hibernate.mappers.UserMapper;
import br.com.pitang.carsapi.user.framework.output.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomUserHibernateAdapter implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsuarioSenhaInvalidosException {
        return repository.findByEmail(email).map(user -> {
            return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(Arrays.asList("USER").toArray(new String[0]))
                    .build();
        }).orElseThrow(() -> new UsuarioSenhaInvalidosException("Invalid login or password"));
    }
}
