package br.com.pitang.carsapi.user.application.usecases;

import br.com.pitang.carsapi.user.domain.entity.User;

/**
 * Interface responsável em recuperar um usuário do sistema
 */
public interface UserGetUseCase {

    /**
     *
     * @param id
     * @return <code>User</code> do id passado como parametro
     */
    User get(String id);

}
