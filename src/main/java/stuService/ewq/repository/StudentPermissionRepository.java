package stuService.ewq.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stuService.ewq.model.Student;
import stuService.ewq.model.StudentPermission;

@Repository
public interface StudentPermissionRepository extends CrudRepository<StudentPermission, Long> {
}
