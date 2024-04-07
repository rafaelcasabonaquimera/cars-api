package br.com.pitang.carsapi.user.application.ports.input;

import br.com.pitang.carsapi.shared.domain.exception.EmailJaExistenteException;
import br.com.pitang.carsapi.user.application.ports.output.UserCreateOutput;
import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.service.UserService;
import br.com.pitang.carsapi.user.domain.vo.InputUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserCreateInput implements UserCreateUseCase {

    @Autowired
    private UserCreateOutput userCreateOutput;

    @Override
    public User create(InputUser input) {
        if (this.userAlreadyExist(input.getEmail())) {
            throw new EmailJaExistenteException("Email already exists");
        }

        return this.userCreateOutput.create(UserService.fromInput(input));
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
}
