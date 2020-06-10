package stuService.ewq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stuService.ewq.model.Permission;
import stuService.ewq.repository.PermissionRepository;


@Service
public class PermissionService {
	
	@Autowired
	PermissionRepository permissionRepository;

}