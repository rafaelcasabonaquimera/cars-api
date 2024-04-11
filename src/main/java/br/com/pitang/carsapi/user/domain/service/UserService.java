package br.com.pitang.carsapi.user.domain.service;

import br.com.pitang.carsapi.user.domain.entity.Car;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.domain.specification.CarSpecification;
import br.com.pitang.carsapi.user.domain.specification.UserSpecification;
import br.com.pitang.carsapi.user.domain.vo.InputUser;

import java.util.stream.Collectors;

public interface UserService {

    /**
     * Transforma objeto de input para objeto de dominio
     * @param input
     * @return <code>User</code>
     */
    static User fromInput(Integer id, InputUser input) {
        var entity = User.builder()
                .id(id)
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .birthday(input.getBirthday())
                .login(input.getLogin())
                .password(input.getPassword())
                .phone(input.getPhone())
                .cars(input.getCars().stream().map(car -> Car.builder()
                        .year(car.getYear())
                        .licensePlate(car.getLicensePlate())
                        .model(car.getModel())
                        .color(car.getColor())
                        .build()).collect(Collectors.toList()))
                .build();

        UserSpecification.firstNameIsNotEmpty().check(entity);
        UserSpecification.lastNameIsNotEmpty().check(entity);
        UserSpecification.emailIsNotEmpty().check(entity);
        UserSpecification.emailIsValid().check(entity);
        UserSpecification.passwordIsNotEmpty().check(entity);
        UserSpecification.phoneIsNotEmpty().check(entity);
        UserSpecification.carsIsNotEmpty().check(entity);

        entity.getCars().stream().forEach(entityCar -> {
            CarSpecification.yearIsNotEmpty().check(entityCar);
            CarSpecification.licensePlateIsNotEmpty().check(entityCar);
            CarSpecification.modelIsNotEmpty().check(entityCar);
            CarSpecification.colorIsNotEmpty().check(entityCar);
        });

        return entity;
    }

}
