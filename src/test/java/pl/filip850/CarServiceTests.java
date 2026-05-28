package pl.filip850;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.filip850.model.CarEntity;
import pl.filip850.model.enums.CarType;
import pl.filip850.repository.CarRepository;
import pl.filip850.service.CarService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTests {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    @DisplayName("Should return available types")
    void test_getCarTypesAvailableBetween_shouldReturnAvailableTypes() {
        // given
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(1);
        List<CarType> expectedTypes = List.of(CarType.Sedan, CarType.SUV);
        when(carRepository.getAvailableCarsBetween(start, end)).thenReturn(expectedTypes);

        // when
        List<CarType> result = carService.getCarTypesAvailableBetween(start, end);

        // then
        assertEquals(expectedTypes, result);
        verify(carRepository).getAvailableCarsBetween(start, end);
    }

    @Test
    @DisplayName("Should save new car")
    void test_addNewCar_shouldSaveNewCar() {
        // given
        CarType type = CarType.Van;
        CarEntity car = new CarEntity(type);
        when(carRepository.save(any(CarEntity.class))).thenReturn(car);

        // when
        CarEntity result = carService.addNewCar(type);

        // then
        assertNotNull(result);
        assertEquals(type, result.getType());
        verify(carRepository).save(any(CarEntity.class));
    }

    @Test
    @DisplayName("Should update car availability")
    void test_changeCarAvailability_shouldUpdateCarAvailability() {
        // given
        Long carId = 1L;
        CarEntity car = new CarEntity(CarType.Sedan);
        car.setAvailable(true);
        when(carRepository.findById(carId)).thenReturn(Optional.of(car));
        when(carRepository.save(any(CarEntity.class))).thenReturn(car);

        // when
        carService.changeCarAvailability(carId, false);

        // then
        assertFalse(car.isAvailable());
        verify(carRepository).findById(carId);
        verify(carRepository).save(car);
    }
}
