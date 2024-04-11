package br.com.pitang.carsapi.user.application.usecases;

import br.com.pitang.carsapi.user.domain.entity.User;

/**
 * Interface responsável em deletar um carro do sistema
 */
public interface UserDeleteUseCase {

    User delete(String id);

}
