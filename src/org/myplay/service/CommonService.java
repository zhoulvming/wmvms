package org.myplay.service;

import java.util.List;

import org.myplay.entity.BaseEntityBean;
import org.myplay.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class CommonService {
	@Autowired
	private CommonRepository commonRepository;

	public List findComboData() {
		return commonRepository.findComboData();
	}

	public void save(BaseEntityBean o) {

		commonRepository.save(o);
	}

}
