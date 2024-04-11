package br.com.pitang.carsapi.user.application.ports.input;

import br.com.pitang.carsapi.user.application.ports.output.UserDeleteOutput;
import br.com.pitang.carsapi.user.application.usecases.UserDeleteUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;

public class UserDeleteInput implements UserDeleteUseCase {

    private UserDeleteOutput userDeleteOutput;

    public UserDeleteInput(UserDeleteOutput userDeleteOutput) {
        this.userDeleteOutput = userDeleteOutput;
    }

    @Override
    public User delete(String id) {
        return userDeleteOutput.delete(id);
    }

}
