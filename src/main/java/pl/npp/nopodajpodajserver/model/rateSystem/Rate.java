package pl.npp.nopodajpodajserver.model.rateSystem;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.rateSystem.Category;
import pl.npp.nopodajpodajserver.model.user.User;

import javax.persistence.*;

@Data
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int score;
    @OneToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Category category;
}
