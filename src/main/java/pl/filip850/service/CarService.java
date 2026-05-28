package pl.filip850.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.filip850.model.CarEntity;
import pl.filip850.model.enums.CarType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {


  public List<CarType> getCarTypesAvailableBetween(LocalDateTime start, LocalDateTime end) {
    return new ArrayList<>();
  }

  public CarEntity addNewCar(CarType type) {
    return null;
  }

  public void changeCarAvailability(Long carId, boolean b) {

  }
}
