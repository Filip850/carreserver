package pl.filip850.model;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class ReservationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime endDate;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "car_id", nullable = false)
  private CarEntity car;

  protected ReservationEntity() {
    // JPA
  }

  public ReservationEntity(CarEntity car, LocalDateTime startDate, LocalDateTime endDate) {
    this.car = car;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public UUID getId() {
    return id;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public CarEntity getCar() {
    return car;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }

    ReservationEntity that = (ReservationEntity) o;

    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
