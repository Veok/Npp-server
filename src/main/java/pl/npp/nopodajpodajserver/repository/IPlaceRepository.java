package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.place.Place;

@Repository("placeRepository")
public interface IPlaceRepository extends JpaRepository<Place,Long> {
}
