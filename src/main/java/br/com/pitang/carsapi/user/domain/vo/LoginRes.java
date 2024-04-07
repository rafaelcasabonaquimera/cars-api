package br.com.pitang.carsapi.user.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Builder(toBuilder = true)
@Getter
@ToString
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {

    private String email;

    private String token;

}
