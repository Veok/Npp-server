package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.user.User;

/**
 * @author Paweł Lelental
 **/
@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    User findByEmail(String email);
}
