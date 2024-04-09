package br.com.pitang.carsapi.shared.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidades detem atributos do login
 * @author Rafael Dias Casabona
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    /**
     * email utilizado para login
     */
    private String email;

    /**
     * password utilizado para login
     */
    private String password;

}
