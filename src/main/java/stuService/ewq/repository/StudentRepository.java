package stuService.ewq.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stuService.ewq.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	Optional<Student> getByIme(String ime);

	void save(Optional<Student> st);

}
