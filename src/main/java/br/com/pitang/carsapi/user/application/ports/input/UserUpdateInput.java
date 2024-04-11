package br.com.pitang.carsapi.user.application.ports.input;

import br.com.pitang.carsapi.user.application.ports.output.UserUpdateOutput;
import br.com.pitang.carsapi.user.application.usecases.UserUpdateUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.service.UserService;
import br.com.pitang.carsapi.user.domain.vo.InputUser;

public class UserUpdateInput implements UserUpdateUseCase {

    private UserUpdateOutput userUpdateOutput;

    public UserUpdateInput(UserUpdateOutput userUpdateOutput) {
        this.userUpdateOutput = userUpdateOutput;
    }

    @Override
    public User update(Integer id, InputUser input) {
        return userUpdateOutput.update(UserService.fromInput(id, input));
    }
}
