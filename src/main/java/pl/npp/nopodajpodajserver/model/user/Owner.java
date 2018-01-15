package pl.npp.nopodajpodajserver.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.model.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Owner")
public class Owner extends User{
    private Place place;
}
