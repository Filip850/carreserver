package pl.filip850.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import pl.filip850.model.error.ExceptionResponse;

@Getter
public class CarIsNotAvailableException extends RuntimeException {
  private final ExceptionResponse responseBody;
  public CarIsNotAvailableException(String messagePl, String messageEn, HttpStatus status) {
    super(messageEn);
    this.responseBody = new ExceptionResponse(messagePl, messageEn, status);
  }
}
