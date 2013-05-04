package org.myplay.service;

import java.util.List;

import org.myplay.repository.CommonRepositoryCustom;
import org.myplay.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class CommonService {
	@Autowired
	private CommonRepositoryCustom commonRepositoryCustom;
	
	@Autowired
	private MyRepository myRepository;

	public List findComboData() {
		return commonRepositoryCustom.findComboData();
	}

	public void save(Object o) {
		myRepository.save(o);

	}

}
