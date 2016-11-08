package ddd.bounded.context.reservation.v1.endpoints;

import ddd.bounded.context.reservation.v1.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by n0048667 on 10/29/16.
 */
@RepositoryRestResource(collectionResourceRel = "reservations")
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @RestResource(path="name")
    Collection<Reservation> findByReservationName(@Param("name") String name);
}
