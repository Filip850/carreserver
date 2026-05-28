package pl.filip850.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.filip850.model.error.ExceptionResponse;

@RestControllerAdvice
public class CarReserverExceptionHandler {

  @ExceptionHandler(CarIsNotAvailableException.class)
  public ResponseEntity<ExceptionResponse> handleCarNotAvailableException(CarIsNotAvailableException ex) {

    return ResponseEntity
        .status(ex.getResponseBody().statusCode())
        .body(ex.getResponseBody());
  }
}
