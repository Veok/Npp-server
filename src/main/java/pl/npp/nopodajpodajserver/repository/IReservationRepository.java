package pl.npp.nopodajpodajserver.repository;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.reservation.Reservation;

import java.util.List;

@Repository("reservationRepository")
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByCustomerId(long id);

    Reservation findById(long id);

    List<Reservation> findByPlaceId(long id);

    List<Reservation> findByTermAndPlaceId(long id);
}
