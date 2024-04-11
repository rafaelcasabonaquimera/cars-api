package br.com.pitang.carsapi.user.framework.input.rest;

import br.com.pitang.carsapi.user.application.usecases.UserCreateUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserDeleteUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserGetUseCase;
import br.com.pitang.carsapi.user.application.usecases.UserUpdateUseCase;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.vo.InputUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users/")
public class UserRestAdapter {

    private UserCreateUseCase userCreateUseCase;

    private UserGetUseCase userGetUseCase;

    private UserDeleteUseCase userDeleteUseCase;

    private UserUpdateUseCase userUpdateUseCase;

    public UserRestAdapter(UserCreateUseCase userCreateUseCase, UserGetUseCase userGetUseCase, UserDeleteUseCase userDeleteUseCase, UserUpdateUseCase userUpdateUseCase) {
        this.userCreateUseCase = userCreateUseCase;
        this.userGetUseCase = userGetUseCase;
        this.userDeleteUseCase = userDeleteUseCase;
        this.userUpdateUseCase = userUpdateUseCase;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> all = userCreateUseCase.findAll();
        return (!all.isEmpty()) ? ResponseEntity.ok(all) : new ResponseEntity(Arrays.asList(""), HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody InputUser input) {
        User user = userCreateUseCase.create(input);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @GetMapping("/port")
    public ResponseEntity<String> port(@Value("${local.server.port}") String port) {
        return ResponseEntity.ok(String.format("Porta utilizada: %s", port));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") String id) {
        User user = this.userGetUseCase.get(id);
        return (user != null) ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity("", HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        User user = this.userDeleteUseCase.delete(id);
        return (user != null) ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity("", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody InputUser input) {
        User user = userUpdateUseCase.update(id, input);
        return (user != null) ? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity("", HttpStatus.NO_CONTENT);
    }

}
