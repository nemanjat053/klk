package stuService.ewq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stuService.ewq.model.FinansijskaKartica;

@Repository
public interface FinansijskaKarticaRepository extends CrudRepository<FinansijskaKartica, Long> {

}
