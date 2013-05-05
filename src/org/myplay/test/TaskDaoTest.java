package org.myplay.test;

import org.junit.Test;
import org.myplay.entity.Organization;
import org.myplay.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TaskDaoTest extends SpringTransactionalTestCase {

	
	@Autowired
	CommonRepository commonRepositoryCustom;
	@Autowired
	CrudRepository<Organization, String>  dao;

	@Test
	public void findTasksByUserId() throws Exception {

//		dao.findAll();
//		myRepository.findAll();
		dao.findAll();
//		commonRepositoryCustom.findComboData();
	}
}
