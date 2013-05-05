package org.myplay.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.myplay.entity.BaseEntityBean;
import org.myplay.web.ComboVo;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository("commonRepository")
public class CommonRepositoryImpl implements CommonRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ComboVo> findCarModelCombo() {
		return em
				.createQuery(
						"select new org.myplay.web.ComboVo(o.id,o.carModel) from CarModel o")
				.getResultList();
	}

	public void save(BaseEntityBean o) {
		if (o.isNew()) {

			o.setId(UUID.randomUUID().toString());
			o.setCreatorCode("abc");
			o.setCreatorId("abc");
			o.setCreateTime(new Date());
			o.setUpdatorCode("abc");
			o.setUpdatorId("abc");
			o.setUpdateTime(new Date());
		} else {

			o.setUpdatorCode("abc");
			o.setUpdatorId("abc");
			o.setUpdateTime(new Date());

		}
		em.persist(o);
	}

	@Override
	public List<ComboVo> findCarCombo() {
		return em
				.createQuery(
						"select new org.myplay.web.ComboVo(o.id,o.carNum) from CarInfo o")
				.getResultList();
	}

	@Override
	public List<ComboVo> findDriverCombo() {
		return em
				.createQuery(
						"select new org.myplay.web.ComboVo(o.id,o.name) from DriverInfo o")
				.getResultList();
	}

	@Override
	public List<ComboVo> findAddressCombo() {
		return em
				.createQuery(
						"select new org.myplay.web.ComboVo(o.id,o.des) from UsualPlace o")
				.getResultList();
	}

	@Override
	public List<ComboVo> findTaskTypeCombo() {
		return em
				.createQuery(
						"select new org.myplay.web.ComboVo(o.id,o.reason) from TaskType o")
				.getResultList();
	}

}
