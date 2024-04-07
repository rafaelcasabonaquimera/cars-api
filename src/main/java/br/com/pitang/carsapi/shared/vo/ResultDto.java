package br.com.pitang.carsapi.shared.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultDto {

    private final String message;

    private final Integer errorCode;

    public static ResultDto success() {
        return new ResultDto(null, null);
    }

    public static ResultDto error(String message, Integer errodCode) {
        return new ResultDto(message, errodCode);
    }

}
