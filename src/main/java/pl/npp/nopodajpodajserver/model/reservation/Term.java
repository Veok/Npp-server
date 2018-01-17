package pl.npp.nopodajpodajserver.model.reservation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Paweł Lelental
 **/
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
