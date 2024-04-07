package br.com.pitang.carsapi.user.domain.specification;

import br.com.pitang.carsapi.user.domain.entity.Car;
import br.com.pitang.carsapi.shared.domain.specification.AbstractSpecification;
import br.com.pitang.carsapi.shared.domain.specification.Specifications;
import br.com.pitang.carsapi.shared.domain.utils.Utils;

public interface CarSpecification {

    static AbstractSpecification<Car> yearIsNotEmpty() {
        return Specifications.basic("Missing fields, year",
                (candidate, v) -> candidate.getYear() != null && Utils.yearIsValid(candidate.getYear()));
    }

    static AbstractSpecification<Car> licensePlateIsNotEmpty() {
        return Specifications.basic("Missing fields, licensePlante",
                (candidate, v) -> candidate.getLicensePlate() != null && !candidate.getLicensePlate().isEmpty());
    }

    static AbstractSpecification<Car> modelIsNotEmpty() {
        return Specifications.basic("Missing fields, model",
                (candidate, v) -> candidate.getModel() != null && !candidate.getModel().isEmpty());
    }

    static AbstractSpecification<Car> colorIsNotEmpty() {
        return Specifications.basic("Missing fields, color",
                (candidate, v) -> candidate.getColor() != null && !candidate.getColor().isEmpty());
    }

}
