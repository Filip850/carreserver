package pl.filip850.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.filip850.model.ReservationEntity;
import pl.filip850.model.enums.CarType;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ReservationService {

    public ReservationEntity reserveCar(CarType type, LocalDateTime startDateTime, int durationDays) {
        // To be implemented
        return null;
    }

    public void cancelReservation(UUID reservationId) {
    }
}
