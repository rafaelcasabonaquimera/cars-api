package br.com.pitang.carsapi.user.application.ports.input;

import br.com.pitang.carsapi.user.application.ports.output.UserGetOutput;
import br.com.pitang.carsapi.user.application.usecases.UserGetUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;

public class UserGetInput implements UserGetUseCase {

    private UserGetOutput userGetOutput;

    public UserGetInput(UserGetOutput userGetOutput) {
        this.userGetOutput = userGetOutput;
    }

    @Override
    public User get(String id) {
        return userGetOutput.get(id);
    }
}
