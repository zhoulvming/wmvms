package org.myplay.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myplay.entity.CarModel;
import org.myplay.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext-shiro.xml"})
public class SpringDaoTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private MyRepository myRepository;

	@Test
	public void saveTest() {
		CarModel o = new CarModel();
		o.setId(UUID.randomUUID().toString());
		o.setCarModel("abc");
		o.setCarry(2);
		myRepository.save(o);
	}

}
