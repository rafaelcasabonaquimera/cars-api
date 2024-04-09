package br.com.pitang.carsapi.shared.domain;

import br.com.pitang.carsapi.shared.application.ports.input.UserAuthInput;
import br.com.pitang.carsapi.shared.application.ports.output.UserAuthOutput;
import br.com.pitang.carsapi.shared.infrastructure.auth.UserAuthSecurityAdapter;
import br.com.pitang.carsapi.shared.infrastructure.auth.security.JwtUtil;
import br.com.pitang.carsapi.user.application.ports.input.UserCreateInput;
import br.com.pitang.carsapi.user.application.ports.output.UserCreateOutput;
import br.com.pitang.carsapi.shared.application.usecases.UserAuthUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.framework.input.rest.UserRestAdapter;
import br.com.pitang.carsapi.user.framework.output.hibernate.UserHibernateAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class Config {

    @Bean
    public UserCreateOutput userCreateOutput() {
        return new UserHibernateAdapter();
    }

    @Bean
    public UserCreateUseCase userCreateUseCase(UserCreateOutput userCreateOutput) {
        return new UserCreateInput(userCreateOutput);
    }

    @Bean
    public UserRestAdapter userRestAdapter(UserCreateUseCase userCreateUseCase) {
        return new UserRestAdapter(userCreateUseCase);
    }

    @Bean
    public UserAuthOutput userAuthInput(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        return new UserAuthSecurityAdapter(authenticationManager, jwtUtil);
    }


    @Bean
    public UserAuthUseCase userAuthUseCase(UserAuthOutput userAuthOutput) {
        return new UserAuthInput(userAuthOutput);
    }

}
