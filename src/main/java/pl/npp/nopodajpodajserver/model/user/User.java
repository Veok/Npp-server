package pl.npp.nopodajpodajserver.model.user;

import lombok.Data;
import pl.npp.nopodajpodajserver.model.rateSystem.Comment;
import pl.npp.nopodajpodajserver.model.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int level;
    private String password;
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private String nickName;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Reservation> reservations;


}
