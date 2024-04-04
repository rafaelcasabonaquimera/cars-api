package br.com.pitang.carsapi.user.domain.entity;

import br.com.pitang.carsapi.car.domain.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
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

    private String firstName;

    private String lastName;

    private String email;

    private Date birthday;

    private String login;

    private String password;

    private String phone;

    private List<Car> cars;

}
