package pl.npp.nopodajpodajserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.npp.nopodajpodajserver.repository.ICommentRepository;

@RestController
@RequestMapping("/comments")
public class CommentRestController {

    @Autowired
    private ICommentRepository commentRepository;
}
