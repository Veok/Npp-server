package pl.npp.nopodajpodajserver.model.rateSystem;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.user.User;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private User user;
    private String text;

}
