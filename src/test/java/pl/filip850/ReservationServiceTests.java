package pl.filip850;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.filip850.model.CarEntity;
import pl.filip850.model.ReservationEntity;
import pl.filip850.model.enums.CarType;
import pl.filip850.repository.CarRepository;
import pl.filip850.repository.ReservationRepository;
import pl.filip850.service.ReservationService;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTests {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    @DisplayName("Should create reservation")
    void test_reserveCar_shouldCreateReservation() {
        // given
        CarType type = CarType.Sedan;
        LocalDateTime start = LocalDateTime.now();
        int duration = 3;
        CarEntity car = new CarEntity(type);
        ReservationEntity reservation = new ReservationEntity(car, start, start.plusDays(duration));

        when(reservationRepository.save(any(ReservationEntity.class))).thenReturn(reservation);

        // when
        ReservationEntity result = reservationService.reserveCar(type, start, duration);

        // then
        assertNotNull(result);
        assertEquals(car, result.getCar());
        assertEquals(start, result.getStartDate());
        verify(reservationRepository).save(any(ReservationEntity.class));
    }

    @Test
    @DisplayName("Should cancel reservation")
    void test_cancelReservation_shouldDeleteReservation() {
        // given
        UUID reservationId = UUID.randomUUID();
        doNothing().when(reservationRepository).deleteById(reservationId);

        // when
        reservationService.cancelReservation(reservationId);

        // then
        verify(reservationRepository).deleteById(reservationId);
    }
}
