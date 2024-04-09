package br.com.pitang.carsapi.shared.application.ports.output;

import br.com.pitang.carsapi.shared.domain.entity.Login;
import br.com.pitang.carsapi.shared.domain.vo.LoginResponse;

public interface UserAuthOutput {
    LoginResponse authenticate(Login entity);

}
