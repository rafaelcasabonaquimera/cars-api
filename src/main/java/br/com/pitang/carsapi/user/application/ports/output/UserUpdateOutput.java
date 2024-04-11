package br.com.pitang.carsapi.user.application.ports.output;

import br.com.pitang.carsapi.user.domain.entity.User;

public interface UserUpdateOutput {

    User update(User entity);

}
