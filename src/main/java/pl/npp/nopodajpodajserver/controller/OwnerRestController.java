package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.npp.nopodajpodajserver.repository.IOwnerRepository;

@RestController
@RequestMapping("/owners")
public class OwnerRestController {

    @Autowired
    private IOwnerRepository ownerRepository;
}
