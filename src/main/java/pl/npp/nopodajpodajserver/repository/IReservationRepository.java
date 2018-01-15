package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.reservation.Reservation;

@Repository("reservationRepository")
public interface IReservationRepository  extends JpaRepository<Reservation,Long>{
}
