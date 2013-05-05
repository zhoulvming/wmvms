package org.myplay.repository;

import java.util.List;

import org.myplay.entity.BaseEntityBean;
import org.myplay.web.ComboVo;

public interface CommonRepository {

	List<ComboVo> findComboData();

	public void save(BaseEntityBean o);
}