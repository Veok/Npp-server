package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.npp.nopodajpodajserver.repository.IRateRepository;

@RestController
@RequestMapping("/rates")
public class RateRestController {

    @Autowired
    private IRateRepository rateRepository;
}
