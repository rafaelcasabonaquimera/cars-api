package br.com.pitang.carsapi.user.framework.output.hibernate;

import br.com.pitang.carsapi.user.application.ports.output.UserDeleteOutput;
import br.com.pitang.carsapi.user.application.ports.output.UserGetOutput;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.framework.output.hibernate.data.UserData;
import br.com.pitang.carsapi.user.framework.output.hibernate.mappers.UserMapper;
import br.com.pitang.carsapi.user.framework.output.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDeleteHibernateAdapter implements UserDeleteOutput {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User delete(String id) {
        UserData userData = repository.findById(id).orElse(null);
        if (userData!=null) {
            repository.delete(userData);
        }
        return mapper.fromData(userData);
    }
}
