package br.com.pitang.carsapi.user.application.usecases;

import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.vo.InputUser;

/**
 * Interface responsavel em atualizar um usuário do sistema
 */
public interface UserUpdateUseCase {

    User update(Integer id, InputUser input);

}
