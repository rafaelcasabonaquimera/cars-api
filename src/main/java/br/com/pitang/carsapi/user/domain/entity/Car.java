package br.com.pitang.carsapi.user.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidade detem atributos do Car
 * @author Rafael Dias Casabona
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    /**
     * Ano de fabricação do carro
     */
    private Integer year;

    /**
     * Placa do carro
     */
    private String licensePlate;

    /**
     * Modelo do carro
     */
    private String model;

    /**
     * Cor predominante do carro
     */
    private String color;

}
