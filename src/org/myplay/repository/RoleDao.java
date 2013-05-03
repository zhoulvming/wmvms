package org.myplay.repository;

import org.myplay.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RoleDao extends PagingAndSortingRepository<Role, String> {
	
	
}
