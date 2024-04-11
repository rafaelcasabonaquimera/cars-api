package br.com.pitang.carsapi.user.framework.output.hibernate;

import br.com.pitang.carsapi.user.application.ports.output.UserGetOutput;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.framework.output.hibernate.mappers.UserMapper;
import br.com.pitang.carsapi.user.framework.output.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGetHibernateAdapter implements UserGetOutput {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User get(String id) {
        return mapper.fromData(repository.findById(id).orElse(null));
    }
}
