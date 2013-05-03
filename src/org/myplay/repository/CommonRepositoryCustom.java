package org.myplay.repository;

import java.util.List;

import org.myplay.web.ComboVo;
import org.springframework.stereotype.Repository;

public interface CommonRepositoryCustom {
	
	List<ComboVo> findComboData();
}