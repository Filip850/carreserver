package pl.filip850.model.error;

import org.springframework.http.HttpStatus;


public record ExceptionResponse(String messagePl, String messageEn, HttpStatus statusCode){ }
