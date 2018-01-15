package pl.npp.nopodajpodajserver.model.user;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.rateSystem.Comment;
import pl.npp.nopodajpodajserver.model.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@Data
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="USER_TYPE")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int level;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    @OneToMany
    private List<Reservation> reservations;


}
