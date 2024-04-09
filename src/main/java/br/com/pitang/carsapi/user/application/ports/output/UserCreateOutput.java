package br.com.pitang.carsapi.user.application.ports.output;

import br.com.pitang.carsapi.user.domain.entity.User;

import java.util.List;

public interface UserCreateOutput {

    User create(User entity);

    List<User> findAll();

    User findById(String id);

    User findByEmail(String email);

    User findByLogin(String login);

}
