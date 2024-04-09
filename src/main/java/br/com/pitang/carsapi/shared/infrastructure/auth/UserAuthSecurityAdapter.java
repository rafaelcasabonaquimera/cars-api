package br.com.pitang.carsapi.shared.infrastructure.auth;

import br.com.pitang.carsapi.shared.application.ports.output.UserAuthOutput;
import br.com.pitang.carsapi.shared.domain.entity.Login;
import br.com.pitang.carsapi.shared.domain.vo.LoginResponse;
import br.com.pitang.carsapi.shared.infrastructure.auth.security.JwtUtil;
import br.com.pitang.carsapi.user.domain.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthSecurityAdapter implements UserAuthOutput {

    private final AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public UserAuthSecurityAdapter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse authenticate(Login entity) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(entity.getEmail(), entity.getPassword()));

        var email = authentication.getName();
        var user = User.builder()
                .email(email)
                .build();

        String token = jwtUtil.createToken(user);
        return new LoginResponse(email, token);
    }

}
