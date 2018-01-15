package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.place.PlaceAmenities;

@Repository("placeAmenities")
public interface IPlaceAmenitiesRepository extends JpaRepository<PlaceAmenities, Long> {

    PlaceAmenities findById(long id);

    PlaceAmenities findByPlaceId(long id);
}
