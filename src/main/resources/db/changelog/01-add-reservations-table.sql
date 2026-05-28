--liquibase formatted sql
--changeset filip850:01-create-reservations-table-and-add-time-validation

CREATE TABLE reservations (
                              id UUID PRIMARY KEY,
                              start_date TIMESTAMP NOT NULL,
                              end_date TIMESTAMP NOT NULL,
                              car_id BIGINT NOT NULL,

                              CONSTRAINT fk_reservations_car
                                  FOREIGN KEY (car_id)
                                      REFERENCES cars(id)
);

ALTER TABLE reservations
    ADD CONSTRAINT chk_reservation_dates
        CHECK (end_date > start_date);