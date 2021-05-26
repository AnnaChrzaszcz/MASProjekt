package mas.demo.repository;

import mas.demo.models.BirthdayParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BirthdayPartyRepository extends CrudRepository<BirthdayParty, Long> {

    List<BirthdayPartyRepository> getAllByDate(LocalDate date);
}
