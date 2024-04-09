package br.com.pitang.carsapi.shared.application.ports.input;

import br.com.pitang.carsapi.shared.application.ports.output.UserAuthOutput;
import br.com.pitang.carsapi.shared.application.usecases.UserAuthUseCase;
import br.com.pitang.carsapi.shared.domain.service.UserAuthService;
import br.com.pitang.carsapi.shared.domain.vo.InputLogin;
import br.com.pitang.carsapi.shared.domain.vo.LoginResponse;

public class UserAuthInput implements UserAuthUseCase {

    private UserAuthOutput userAuthOutput;

    public UserAuthInput(UserAuthOutput userAuthOutput) {
        this.userAuthOutput = userAuthOutput;
    }

    @Override
    public LoginResponse authenticate(InputLogin input) {
        return userAuthOutput.authenticate(UserAuthService.fromInput(input));
    }

}
