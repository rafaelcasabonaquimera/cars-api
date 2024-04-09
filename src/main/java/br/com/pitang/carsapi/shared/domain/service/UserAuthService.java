package br.com.pitang.carsapi.shared.domain.service;

import br.com.pitang.carsapi.shared.domain.entity.Login;
import br.com.pitang.carsapi.shared.domain.vo.InputLogin;

public interface UserAuthService {

    /**
     * Transforma objeto de input para objeto de dominio
     * @param input
     * @return <code>Login</code>
     */
    static Login fromInput(InputLogin input) {
        return Login.builder()
                .email(input.getEmail())
                .password(input.getPassword())
                .build();
    }

}
