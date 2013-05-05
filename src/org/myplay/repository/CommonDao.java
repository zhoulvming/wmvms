package org.myplay.repository;

import java.util.List;

import org.myplay.entity.Organization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommonDao  extends PagingAndSortingRepository<Organization,String> {
	
	@Query(" select o from Organization o where o.deleteFlag=0")
	List<Organization> findAllOrg();

}
