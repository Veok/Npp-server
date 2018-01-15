package pl.npp.nopodajpodajserver.model.reservation;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean isTaken;
    private Date date;
    private Reservation reservation;
}
