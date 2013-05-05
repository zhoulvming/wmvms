package org.myplay.test;

import org.junit.Test;
import org.myplay.entity.Organization;
import org.myplay.repository.CommonDao;
import org.myplay.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TaskDaoTest extends SpringTransactionalTestCase {

	@Autowired
	private CommonDao dao;
	@Autowired
	private MyRepository<Organization,String> myRepository;

	@Test
	public void findTasksByUserId() throws Exception {

//		dao.findAll();
		myRepository.findAllOrg();
	}
}
