package org.myplay.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.myplay.entity.Assign;
import org.myplay.entity.Organization;
import org.myplay.web.ComboVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DispatchDao extends
		PagingAndSortingRepository<Assign, String> {
	
	@Query(" select max(serialID) from Assign o where o.serialID like ? ")
	String getMaxSerialID(String param);

}
