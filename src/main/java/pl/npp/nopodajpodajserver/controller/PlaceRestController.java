package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.npp.nopodajpodajserver.repository.IPlaceRepository;

@RestController
@RequestMapping("/places")
public class PlaceRestController {

    @Autowired
    private IPlaceRepository placeRepository;
}
