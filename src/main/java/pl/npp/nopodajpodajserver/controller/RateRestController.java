package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.npp.nopodajpodajserver.model.rateSystem.Rate;
import pl.npp.nopodajpodajserver.repository.IRateRepository;

import java.util.List;

/**
 * @author Paweł Lelental
 **/
@RestController
@RequestMapping("/rates")
public class RateRestController {

    @Autowired
    private IRateRepository rateRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Rate>> getRates() {
        return new ResponseEntity<>(rateRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Rate> getRate(@PathVariable long id) {
        Rate rate = rateRepository.findById(id);
        if (rate != null) {
            return new ResponseEntity<>(rate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Rate) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addRate(@RequestBody Rate rate) {
        return new ResponseEntity<>(rateRepository.save(rate), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRate(@PathVariable long id) {
        rateRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
