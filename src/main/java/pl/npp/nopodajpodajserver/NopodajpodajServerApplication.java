package pl.npp.nopodajpodajserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Paweł Lelental
 **/
@SpringBootApplication
@EnableResourceServer
@EntityScan("pl.nopodajpodajserver.model")
public class NopodajpodajServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NopodajpodajServerApplication.class, args);
    }
}
