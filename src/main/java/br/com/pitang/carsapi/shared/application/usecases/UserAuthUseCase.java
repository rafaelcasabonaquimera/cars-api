package br.com.pitang.carsapi.shared.application.usecases;

import br.com.pitang.carsapi.shared.domain.vo.InputLogin;
import br.com.pitang.carsapi.shared.domain.vo.LoginResponse;

public interface UserAuthUseCase {

    LoginResponse authenticate(InputLogin input);

}
