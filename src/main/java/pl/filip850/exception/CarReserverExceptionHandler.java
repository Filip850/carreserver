package pl.filip850.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filip850.model.error.ExceptionResponse;

@RestControllerAdvice
public class CarReserverExceptionHandler {

//  @ExceptionHandler()
  public ResponseEntity<ExceptionResponse> handleCarNotAvailableException() {
    return ResponseEntity
        .status(409)
        .body(new ExceptionResponse(
            "Samochod nie jest dostepny w tym terminie",
            "Car is unavailable in this time",
            409
        ));
  }
}
