package org.myplay.repository;

import org.myplay.entity.DepartmentStruc;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrgBindDao extends
		PagingAndSortingRepository<DepartmentStruc, String> {

}
