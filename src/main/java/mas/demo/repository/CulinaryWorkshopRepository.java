package mas.demo.repository;

import mas.demo.models.Client;
import mas.demo.models.CulinaryWorkshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulinaryWorkshopRepository extends CrudRepository<CulinaryWorkshop, Long> {
}
