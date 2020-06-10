package stuService.ewq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stuService.ewq.model.Transakcija;

@Repository
public interface TransakcijaRepository extends CrudRepository<Transakcija, Long>{

}
