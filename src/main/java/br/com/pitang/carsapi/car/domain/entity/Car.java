package br.com.pitang.carsapi.car.domain.entity;

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

    private Integer year;

    private String licensePlate;

    private String model;

    private String color;

}
