package br.com.pitang.carsapi.shared.infrastructure;

import br.com.pitang.carsapi.shared.application.ports.input.UserAuthInput;
import br.com.pitang.carsapi.shared.application.ports.output.UserAuthOutput;
import br.com.pitang.carsapi.shared.infrastructure.auth.UserAuthSecurityAdapter;
import br.com.pitang.carsapi.shared.infrastructure.auth.security.JwtUtil;
import br.com.pitang.carsapi.user.application.ports.input.UserCreateInput;
import br.com.pitang.carsapi.user.application.ports.input.UserDeleteInput;
import br.com.pitang.carsapi.user.application.ports.input.UserGetInput;
import br.com.pitang.carsapi.user.application.ports.input.UserUpdateInput;
import br.com.pitang.carsapi.user.application.ports.output.UserCreateOutput;
import br.com.pitang.carsapi.shared.application.usecases.UserAuthUseCase;
import br.com.pitang.carsapi.user.application.ports.output.UserDeleteOutput;
import br.com.pitang.carsapi.user.application.ports.output.UserGetOutput;
import br.com.pitang.carsapi.user.application.ports.output.UserUpdateOutput;
import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserDeleteUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserGetUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserUpdateUseCase;
import br.com.pitang.carsapi.user.framework.input.rest.UserRestAdapter;
import br.com.pitang.carsapi.user.framework.output.hibernate.UserCreateHibernateAdapter;
import br.com.pitang.carsapi.user.framework.output.hibernate.UserGetHibernateAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class Config {

    @Bean
    public UserCreateOutput userCreateOutput() {
        return new UserCreateHibernateAdapter();
    }

    @Bean
    public UserCreateUseCase userCreateUseCase(UserCreateOutput userCreateOutput) {
        return new UserCreateInput(userCreateOutput);
    }

    @Bean
    public UserGetOutput userGetOutput() {
        return new UserGetHibernateAdapter();
    }

    @Bean
    public UserGetUseCase userGetUseCase(UserGetOutput userGetOutput) {
        return new UserGetInput(userGetOutput);
    }

    @Bean
    public UserDeleteUseCase userDeleteUseCase(UserDeleteOutput userDeleteOutput) {
        return new UserDeleteInput(userDeleteOutput);
    }

    @Bean
    public UserUpdateUseCase userUpdateUseCase(UserUpdateOutput userUpdateOutput) {
        return new UserUpdateInput(userUpdateOutput);
    }

    @Bean
    public UserRestAdapter userRestAdapter(UserCreateUseCase userCreateUseCase, UserGetUseCase userGetUseCase, UserDeleteUseCase userDeleteUseCase, UserUpdateUseCase userUpdateUseCase) {
        return new UserRestAdapter(userCreateUseCase, userGetUseCase, userDeleteUseCase, userUpdateUseCase);
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
