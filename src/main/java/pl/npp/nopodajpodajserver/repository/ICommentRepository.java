package pl.npp.nopodajpodajserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.npp.nopodajpodajserver.model.rateSystem.Comment;

@Repository("commentRepository")
public interface ICommentRepository extends JpaRepository<Comment,Long> {
}
