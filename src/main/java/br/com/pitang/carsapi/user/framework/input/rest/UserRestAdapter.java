package br.com.pitang.carsapi.user.framework.input.rest;

import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.vo.InputUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users/", name = "users")
public class UserRestAdapter {

    private UserCreateUseCase userCreateUseCase;

    public UserRestAdapter(UserCreateUseCase userCreateUseCase) {
        this.userCreateUseCase = userCreateUseCase;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userCreateUseCase.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody InputUser input) {
        User user = userCreateUseCase.create(input);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}
