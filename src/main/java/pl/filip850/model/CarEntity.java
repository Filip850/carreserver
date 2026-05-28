package pl.filip850.model;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import pl.filip850.model.enums.CarType;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cars")
public class CarEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private CarType type;

  @Column(nullable = false)
  private boolean available = true;

  protected CarEntity() {
    // JPA
  }

  public CarEntity(CarType type) {
    this.type = type;
    this.available = true;
  }

  public Long getId() {
    return id;
  }

  public CarType getType() {
    return type;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }

    CarEntity that = (CarEntity) o;

    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
