package br.com.pitang.carsapi.user.application.usecases;

import br.com.pitang.carsapi.user.domain.entity.User;

import java.util.List;

/**
 * Interface que lista os usuários cadastrados
 * @author Rafael Casabona
 */
public interface UserListUseCase {

    /**
     *
     * @param idUser
     * @return uma lista <code>List<User></code> todos os usuários
     */
    List<User> list(String idUser);

}
