package pl.npp.nopodajpodajserver.model.user;

import lombok.Data;

import pl.npp.nopodajpodajserver.model.reservation.Reservation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.enabled;

/**
 * @author Paweł Lelental
 **/
@Data
@MappedSuperclass
public class User {

    static final long serialVersionUID = 1L;

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
    private boolean enabled;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return new ArrayList<GrantedAuthority>();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        // we never lock accounts
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        // credentials never expire
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
}
