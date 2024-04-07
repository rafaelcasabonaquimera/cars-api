package br.com.pitang.carsapi.user.framework.output.hibernate.repository;

import br.com.pitang.carsapi.user.framework.output.hibernate.data.CarData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarData, String> {
}
