package org.myplay.service;

import java.util.List;

import org.myplay.repository.CommonRepositoryCustom;
import org.myplay.repository.CommonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class CommonService {
	private CommonRepositoryCustom commonRepositoryCustom;

	@Autowired
	public void setCommonRepositoryCustom(
			CommonRepositoryCustom commonRepositoryCustom) {
		this.commonRepositoryCustom = commonRepositoryCustom;
	}

	public List findComboData() {

		return commonRepositoryCustom.findComboData();
	}

}
