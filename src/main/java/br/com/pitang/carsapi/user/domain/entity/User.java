package br.com.pitang.carsapi.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Entidade detem atributos do User
 * @author Rafael Dias Casabona
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String birthday;

    private String login;

    private String password;

    private String phone;

    private List<Car> cars;

}
