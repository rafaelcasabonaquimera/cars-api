package br.com.pitang.carsapi.user.framework.output.hibernate.repository;

import br.com.pitang.carsapi.user.framework.output.hibernate.data.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserData, String> {

    @Override
    List<UserData> findAll();

    Optional<UserData> findByEmail(String email);

    Optional<UserData> findByLogin(String login);

}
