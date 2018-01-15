package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.rateSystem.Category;
import pl.npp.nopodajpodajserver.model.rateSystem.Rate;
import pl.npp.nopodajpodajserver.model.user.Customer;

import java.util.List;

@Repository("rateRepository")
public interface IRateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByPlaceId(long id);

    List<Rate> findByCustomer(Customer customer);

    Rate findById(long id);

    List<Rate> findByScore(double score);

    List<Rate> findByCategory(Category category);

}
