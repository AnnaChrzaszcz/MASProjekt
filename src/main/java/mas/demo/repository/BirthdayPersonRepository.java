package mas.demo.repository;

import mas.demo.models.BirthdayPerson;
import mas.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthdayPersonRepository extends CrudRepository<BirthdayPerson, Long> {
}
