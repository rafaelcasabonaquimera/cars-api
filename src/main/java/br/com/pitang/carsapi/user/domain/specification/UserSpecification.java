package br.com.pitang.carsapi.user.domain.specification;

import br.com.pitang.carsapi.shared.domain.Constants;
import br.com.pitang.carsapi.shared.domain.specification.AbstractSpecification;
import br.com.pitang.carsapi.shared.domain.specification.Specifications;
import br.com.pitang.carsapi.shared.domain.utils.Utils;
import br.com.pitang.carsapi.user.domain.entity.User;

import java.util.regex.Pattern;

public interface UserSpecification {

    Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(Constants.REGEX_EMAIL, Pattern.CASE_INSENSITIVE);

    static AbstractSpecification<User> firstNameIsNotEmpty() {
        return Specifications.basic("Missing fields, firstName",
                (candidate, v) -> candidate.getFirstName() != null && !candidate.getFirstName().isEmpty());
    }

    static AbstractSpecification<User> lastNameIsNotEmpty() {
        return Specifications.basic("Missing fields, lastName",
                (candidate, v) -> candidate.getLastName() != null && !candidate.getLastName().isEmpty());
    }

    static AbstractSpecification<User> emailIsNotEmpty() {
        return Specifications.basic("Missing fields, email",
                (candidate, v) -> candidate.getEmail() != null && !candidate.getEmail().isEmpty());
    }

    static AbstractSpecification<User> emailIsValid() {
        return Specifications.basic("Invalid fields, email",
                (candidate, v) -> candidate.getEmail() != null && Utils.patternMatches(candidate.getEmail(), VALID_EMAIL_ADDRESS_REGEX));
    }

    static AbstractSpecification<User> passwordIsNotEmpty() {
        return Specifications.basic("Missing fields, password",
                (candidate, v) -> candidate.getPassword() != null && !candidate.getPassword().isEmpty());
    }

    static AbstractSpecification<User> phoneIsNotEmpty() {
        return Specifications.basic("Missing fields, phone",
                (candidate, v) -> candidate.getPhone() != null && !candidate.getPhone().isEmpty());
    }

    static AbstractSpecification<User> carsIsNotEmpty() {
        return Specifications.basic("Missing fields, car",
                (candidate, v) -> candidate.getCars() != null && candidate.getCars().size() > 0);
    }

}
