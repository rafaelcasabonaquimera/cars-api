package br.com.pitang.carsapi.user.framework.output.hibernate;

import br.com.pitang.carsapi.user.application.ports.output.UserCreateOutput;
import br.com.pitang.carsapi.user.domain.entity.Car;
import br.com.pitang.carsapi.user.domain.entity.User;
import br.com.pitang.carsapi.user.framework.output.hibernate.data.UserData;
import br.com.pitang.carsapi.user.framework.output.hibernate.mappers.CarMapper;
import br.com.pitang.carsapi.user.framework.output.hibernate.mappers.UserMapper;
import br.com.pitang.carsapi.user.framework.output.hibernate.repository.CarRepository;
import br.com.pitang.carsapi.user.framework.output.hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserCreateHibernateAdapter implements UserCreateOutput {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public User create(User entity) {
        final UserData userSave = repository.save(mapper.toData(entity));
        final List<Car> carList = new ArrayList<>();

        entity.getCars().forEach(car -> {
            carList.add(carMapper.fromData(carRepository.save(carMapper.toData(car, userSave))));
        });

        final User user = mapper.fromData(userSave, carList);
        user.setCars(carList);

        return user;
    }

    @Override
    public List<User> findAll() {
        List<UserData> list = repository.findAll();
        if (list != null) {
            return list.stream().map(user -> mapper.fromData(user)).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public User findById(String id) {
        return this.mapper.fromData(repository.findById(id).orElse(UserData.builder().build()));
    }

    @Override
    public User findByEmail(String email) {
        Optional<UserData> optionalUserData = repository.findByEmail(email);
        return this.mapper.fromData(optionalUserData.orElse(UserData.builder().build()));
    }

    @Override
    public User findByLogin(String login) {
        Optional<UserData> optionalUserData = repository.findByLogin(login);
        return this.mapper.fromData(optionalUserData.orElse(UserData.builder().build()));
    }

}
