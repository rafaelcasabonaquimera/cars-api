package br.com.pitang.carsapi.user.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder(toBuilder = true)
@Getter
@ToString
@Jacksonized
public class InputUser {

    private String firstName;

    private String lastName;

    private String email;

    private String birthday;

    private String login;

    private String password;

    private String phone;

    private List<InputCar> cars;

}
