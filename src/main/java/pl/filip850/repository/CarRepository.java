package pl.filip850.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.filip850.model.CarEntity;
import pl.filip850.model.enums.CarType;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

  @Query(value = """
        SELECT DISTINCT c.type
        FROM CarEntity c
        WHERE NOT EXISTS (
            SELECT 1
            FROM ReservationEntity r
            WHERE r.car.id = c.id
              AND r.startDate < :endDate
              AND r.endDate > :startDate
        )
        """)
  List<CarType> getAvailableCarsBetween(LocalDateTime startDate, LocalDateTime endDate);
}
