package pl.npp.nopodajpodajserver.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.npp.nopodajpodajserver.model.user.Customer;
import pl.npp.nopodajpodajserver.repository.ICustomerRepository;

import java.security.Principal;
import java.util.List;

/**
 * @author Paweł Lelental
 **/
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Customer) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        customer.setLevel(1);
        customer.setPassword(DigestUtils.sha1Hex(customer.getPassword()));
        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id, Principal principal) {
        Customer currentCustomer = customerRepository.findByEmail(principal.getName());

        if (currentCustomer.getId() == id) {
            customerRepository.delete(currentCustomer);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
