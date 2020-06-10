package stuService.ewq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stuService.ewq.model.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {

}
