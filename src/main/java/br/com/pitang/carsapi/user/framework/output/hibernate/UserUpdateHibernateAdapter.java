package br.com.pitang.carsapi.user.framework.output.hibernate;

import br.com.pitang.carsapi.user.application.ports.output.UserUpdateOutput;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.framework.output.hibernate.data.UserData;
import br.com.pitang.carsapi.user.framework.output.hibernate.mappers.UserMapper;
import br.com.pitang.carsapi.user.framework.output.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateHibernateAdapter implements UserUpdateOutput {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public User update(User entity) {
        UserData userData = repository.findById(entity.getId().toString()).orElse(null);

        if (userData==null) {
            return null;
        }

        UserData dataUpdate = mapper.toData(userData.getId(), entity);
        repository.save(dataUpdate);
        return mapper.fromData(dataUpdate);
    }
}
