package br.com.pitang.carsapi.user.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Builder(toBuilder = true)
@Getter
@ToString
@Jacksonized
public class InputCar {

    private Integer year;

    private String licensePlate;

    private String model;

    private String color;

}
