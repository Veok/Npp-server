package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.npp.nopodajpodajserver.model.place.Place;
import pl.npp.nopodajpodajserver.repository.IPlaceRepository;

import java.util.List;

/**
 * @author Paweł Lelental
 **/
@RestController
@RequestMapping("/places")
public class PlaceRestController {

    @Autowired
    private IPlaceRepository placeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Place>> getPlaces() {
        return new ResponseEntity<>(placeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Place> getPlace(@PathVariable long id) {
        Place place = placeRepository.findById(id);
        if (place != null) {
            return new ResponseEntity<>(place, HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Place) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPlace(@RequestBody Place place) {
        return new ResponseEntity<>(placeRepository.save(place), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePlace(@PathVariable long id) {
        placeRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
