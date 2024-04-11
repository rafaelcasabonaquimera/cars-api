package br.com.pitang.carsapi.user.application.ports.input;

import br.com.pitang.carsapi.shared.domain.exception.EmailJaExistenteException;
import br.com.pitang.carsapi.shared.domain.exception.LoginJaExistenteException;
import br.com.pitang.carsapi.user.application.ports.output.UserCreateOutput;
import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.service.UserService;
import br.com.pitang.carsapi.user.domain.vo.InputUser;

import java.util.List;

public class UserCreateInput implements UserCreateUseCase {

    private UserCreateOutput userCreateOutput;

    public UserCreateInput(UserCreateOutput userCreateOutput) {
        this.userCreateOutput = userCreateOutput;
    }

    @Override
    public User create(InputUser input) {
        if (this.userAlreadyExist(input.getEmail())) {
            throw new EmailJaExistenteException("Email already exists");
        }

        if (this.loginAlreadyExist(input.getLogin())) {
            throw new LoginJaExistenteException("Login already exists");
        }

        return this.userCreateOutput.create(UserService.fromInput(null, input));
    }

    @Override
    public List<User> findAll() {
        return this.userCreateOutput.findAll();
    }

    private boolean userAlreadyExist(String email) {
        User user = this.userCreateOutput.findByEmail(email);
        if (user != null && user.getId() != null){
            return true;
        }
        return false;
    }

    private boolean loginAlreadyExist(String login) {
        User user = this.userCreateOutput.findByLogin(login);
        if (user != null && user.getId() != null){
            return true;
        }
        return false;
    }
}
