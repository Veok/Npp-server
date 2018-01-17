package pl.npp.nopodajpodajserver.model.rateSystem;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.model.user.User;

import javax.persistence.*;

/**
 * @author Paweł Lelental
 **/
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private User user;
    @OneToOne
    private Place place;
    private String text;

}
