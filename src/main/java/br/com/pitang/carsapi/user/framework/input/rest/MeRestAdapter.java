package br.com.pitang.carsapi.user.framework.input.rest;

import br.com.pitang.carsapi.user.domain.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class MeRestAdapter {
    @GetMapping
    public ResponseEntity<User> user() {
        return ResponseEntity.ok(User.builder().build());
    }

}
