package pl.npp.nopodajpodajserver.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.npp.nopodajpodajserver.model.rateSystem.Comment;
import pl.npp.nopodajpodajserver.model.rateSystem.Rate;
import pl.npp.nopodajpodajserver.model.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Customer")
public class Customer extends User {

    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Rate> rates;
    @OneToMany
    private List<Reservation> reservations;
}
