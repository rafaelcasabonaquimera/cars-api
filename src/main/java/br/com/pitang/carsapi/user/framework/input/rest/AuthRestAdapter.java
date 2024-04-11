package br.com.pitang.carsapi.user.framework.input.rest;

import br.com.pitang.carsapi.shared.application.usecases.UserAuthUseCase;
import br.com.pitang.carsapi.shared.domain.vo.InputLogin;
import br.com.pitang.carsapi.shared.domain.vo.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signin")
public class AuthRestAdapter {

    private UserAuthUseCase userAuthUseCase;

    public AuthRestAdapter(UserAuthUseCase userAuthUseCase) {
        this.userAuthUseCase = userAuthUseCase;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody InputLogin inputLogin)  {
        return new ResponseEntity(userAuthUseCase.authenticate(inputLogin), HttpStatus.OK);
    }

}
