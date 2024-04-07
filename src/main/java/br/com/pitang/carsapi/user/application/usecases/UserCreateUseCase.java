package br.com.pitang.carsapi.user.application.usecases;

import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.vo.InputUser;

import java.util.List;

/**
 * Interface responsável em criar um carro
 * @author Rafael Casabona
 */
public interface UserCreateUseCase {

    /**
     *
     * @param input
     * @return um objeto <code>User</code> representando o Usuário criado
     */
    User create(InputUser input);

    /**
     *
     * @return lista <code>List<User></code> dos usuários cadastrados
     */
    List<User> findAll();

}
