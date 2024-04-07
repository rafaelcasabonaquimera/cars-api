package br.com.pitang.carsapi.shared.vo;

public enum StatusError {

    EMAIL_ALREADY_EXISTS("Email already exists", 200);

    private String message;

    private Integer codeError;

    StatusError(String message, Integer codeError) {
        this.message = message;
        this.codeError = codeError;
    }

    public String getMessage() {
        return this.message;
    }

}
