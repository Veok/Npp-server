package pl.npp.nopodajpodajserver.model.place;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Paweł Lelental
 **/
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
    @OneToOne
    private Place place;
}
