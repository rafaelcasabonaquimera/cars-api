package br.com.pitang.carsapi.shared.domain;

import br.com.pitang.carsapi.user.application.ports.input.UserCreateInput;
import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.framework.output.rest.UserRestAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserCreateUseCase userCreateUseCase() {
        return new UserCreateInput();
    }

    @Bean
    public UserRestAdapter userRestAdapter(UserCreateUseCase userCreateUseCase) {
        return new UserRestAdapter(userCreateUseCase);
    }

}
