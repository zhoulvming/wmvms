package org.myplay.repository;

import java.util.List;

import org.myplay.entity.BaseEntityBean;
import org.myplay.web.ComboVo;

public interface CommonRepository {

	List<ComboVo> findCarModelCombo();
	
	List<ComboVo> findCarCombo();
	
	List<ComboVo> findDriverCombo();
	
	List<ComboVo> findAddressCombo();
	
	List<ComboVo> findTaskTypeCombo();

	public void save(BaseEntityBean o);
}