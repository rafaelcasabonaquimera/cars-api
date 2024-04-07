package br.com.pitang.carsapi.user.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Builder(toBuilder = true)
@Getter
@ToString
@Jacksonized
public class LoginReq {

    private String email;

    private String password;

}
