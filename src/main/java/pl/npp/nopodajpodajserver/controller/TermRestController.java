package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.npp.nopodajpodajserver.repository.ITermRepository;

@RestController
@RequestMapping("/terms")
public class TermRestController
{
    @Autowired
    private ITermRepository termRepository;
}
