package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.user.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {
}
