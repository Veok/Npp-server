package pl.npp.nopodajpodajserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.npp.nopodajpodajserver.model.user.User;
import pl.npp.nopodajpodajserver.repository.ICustomerRepository;
import pl.npp.nopodajpodajserver.repository.IOwnerRepository;
import pl.npp.nopodajpodajserver.repository.IUserRepository;

/**
 * @author Paweł Lelental
 **/
@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    IOwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);

        if (user.getLevel() == 1) {
            return customerRepository.findByEmail(user.getEmail());
        }

        if (user.getLevel() == 2) {
            return ownerRepository.findByEmail(user.getEmail());
        }


        return user;
    }
}
