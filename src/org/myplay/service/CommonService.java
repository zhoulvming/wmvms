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

	public List findCarModelCombo() {
		return commonRepository.findCarModelCombo();
	}
	public List findCarCombo() {
		return commonRepository.findCarCombo();
	}
	public List findDriverCombo() {
		return commonRepository.findDriverCombo();
	}
	
	public List findAddressCombo() {
		return commonRepository.findAddressCombo();
	}
	
	public List findTaskTypeCombo() {
		return commonRepository.findTaskTypeCombo();
	}
	public void save(BaseEntityBean o) {

		commonRepository.save(o);
	}

}
