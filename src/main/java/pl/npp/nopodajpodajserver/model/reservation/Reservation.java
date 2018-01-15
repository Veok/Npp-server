package pl.npp.nopodajpodajserver.model.reservation;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Place place;
    @OneToOne
    private User user;
    private String typeOfPayment;
}
