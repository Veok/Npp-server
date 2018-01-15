package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.rateSystem.Rate;

@Repository("rateRepository")
public interface IRateRepository extends JpaRepository<Rate,Long> {
}
