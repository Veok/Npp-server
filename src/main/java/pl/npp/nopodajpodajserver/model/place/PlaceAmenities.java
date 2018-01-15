package pl.npp.nopodajpodajserver.model.place;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PlaceAmenities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean hasShower;
    private boolean hasChangingRoom;
    private boolean hasLightsOutside;
    private boolean hasFreeWater;
}
