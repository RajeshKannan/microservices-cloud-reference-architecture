package ddd.bounded.context.reservation.v1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Rajesh Kannan Poraiyan on 10/29/16.
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    Reservation() { // why JPA why??
    }

    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationName='" + reservationName + '\'' +
                '}';
    }

    private String reservationName;

    public Long getId() {
        return id;
    }

    public String getReservationName() {
        return reservationName;
    }
}