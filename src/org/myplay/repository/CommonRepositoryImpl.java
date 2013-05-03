package org.myplay.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.myplay.web.ComboVo;
import org.springframework.stereotype.Repository;
@Repository("commonRepositoryCustom")
public class CommonRepositoryImpl implements CommonRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ComboVo> findComboData() {
		
		return em.createQuery("select new org.myplay.web.ComboVo(o.id,o.carModel) from CarModel o").getResultList();
	}

	
	
}
