package org.myplay.repository;

import java.io.Serializable;
import java.util.List;

import org.myplay.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MyRepository<T, ID extends Serializable> extends
		JpaRepository<T, ID> {
	@Query(" select o from Organization o where o.deleteFlag=0")
	List<Organization> findAllOrg();
}
