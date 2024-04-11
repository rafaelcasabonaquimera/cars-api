package br.com.pitang.carsapi.user.framework.output.hibernate.mappers;

import br.com.pitang.carsapi.user.domain.entity.Car;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.framework.output.hibernate.data.UserData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User fromData(UserData data) {
        if (data==null) {
            return null;
        }

        List<Car> listCar = new ArrayList<>();
        if (data.getCars() != null) {
            listCar = data.getCars().stream()
                    .filter(car -> Objects.nonNull(car))
                    .map(car -> Car.builder()
                            .year(car.getYear())
                            .licensePlate(car.getLicensePlate())
                            .model(car.getModel())
                            .color(car.getColor())
                            .build()).collect(Collectors.toList());
        }

        return User.builder()
                .id(data.getId())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .email(data.getEmail())
                .birthday(data.getBirthday())
                .login(data.getLogin())
                .password(data.getPassword())
                .phone(data.getPhone())
                .cars(listCar)
                .build();
    }

    public User fromData(UserData data, List<Car> carList) {
        return User.builder()
                .id(data.getId())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .email(data.getEmail())
                .birthday(data.getBirthday())
                .login(data.getLogin())
                .password(data.getPassword())
                .phone(data.getPhone())
                .cars(carList)
                .build();
    }

    public UserData toData(User entity) {
        var data = UserData.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .birthday(entity.getBirthday())
                .login(entity.getLogin())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .build();

        return data;
    }

    public UserData toData(Integer id, User user) {
        return UserData.builder()
                .id(id)
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .login(user.getLogin())
                .password(user.getPassword())
                .phone(user.getPhone())
                .build();
    }

}
