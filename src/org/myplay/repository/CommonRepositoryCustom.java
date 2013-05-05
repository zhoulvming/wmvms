package org.myplay.repository;

import java.util.List;

import org.myplay.web.ComboVo;

public  interface CommonRepositoryCustom{
	
	List<ComboVo> findComboData();
}