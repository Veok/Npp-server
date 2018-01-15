package pl.npp.nopodajpodajserver.model.rateSystem;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.model.rateSystem.Category;
import pl.npp.nopodajpodajserver.model.user.Customer;
import pl.npp.nopodajpodajserver.model.user.User;

import javax.persistence.*;

@Data
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int score;
    @ManyToOne
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private Category category;
    @OneToOne
    private Place place;
}
