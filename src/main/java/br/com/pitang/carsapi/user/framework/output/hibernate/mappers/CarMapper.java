package br.com.pitang.carsapi.user.framework.output.hibernate.mappers;

import br.com.pitang.carsapi.user.domain.entity.Car;
import br.com.pitang.carsapi.user.framework.output.hibernate.data.CarData;
import br.com.pitang.carsapi.user.framework.output.hibernate.data.UserData;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarData toData(Car entity, UserData userData) {
        return CarData.builder()
                .year(entity.getYear())
                .licensePlate(entity.getLicensePlate())
                .model(entity.getModel())
                .color(entity.getColor())
                .user(userData)
                .build();
    }

    public Car fromData(CarData data) {
        return Car.builder()
                .year(data.getYear())
                .licensePlate(data.getLicensePlate())
                .model(data.getModel())
                .color(data.getColor())
                .build();
    }

}
