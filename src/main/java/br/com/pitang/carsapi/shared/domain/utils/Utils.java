package br.com.pitang.carsapi.shared.domain.utils;

import br.com.pitang.carsapi.shared.domain.Constants;
import org.apache.commons.validator.routines.DateValidator;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.regex.Pattern;

public interface Utils {

    static boolean yearIsValid(Integer year) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(Constants.DAFE_FORMAT_YEAR, Locale.US)
                .withResolverStyle(ResolverStyle.STRICT);
        DateValidator validator = new DateValidatorUsingDateTimeFormatter(dateFormatter);
        return validator.isValid(year.toString());
    }

    static boolean patternMatches(String value, Pattern regexPattern) {
        return regexPattern.matcher(value).matches();
    }


}
