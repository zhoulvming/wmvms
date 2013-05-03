package org.myplay.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.myplay.entity.BaseEntityBean;
import org.myplay.entity.JsonResult;
import org.myplay.entity.SimpleBaseEntityBean;
import org.myplay.repository.IGenericDAO;
import org.myplay.util.Tools;

public abstract class AbstractBaseResource<T> {

	private static final int CONSTANT_VALID_FLAG = 0;
	private static final int CONSTANT_INVALID_FLAG = 1;
	private JsonResult<T> jsonResult = null;

	public JsonResult<T> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JsonResult<T> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String getSearchField() throws Exception, JsonMappingException,
			IOException {
		jsonResult.build(clazz);
		ObjectMapper mapper = new ObjectMapper();

		// mapper.configure(
		// SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
		// false);// 封闭时候戳输出，此时是ISO格局

		return mapper.writeValueAsString(jsonResult);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map json2Map(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		Iterator keyIter = jsonObject.keys();
		String key;
		Object value;
		Map valueMap = new HashMap();
		while (keyIter.hasNext()) {
			key = (String) keyIter.next();
			value = jsonObject.get(key);
			valueMap.put(key, value);
		}
		return valueMap;
	}

	private IGenericDAO<BaseEntityBean, String> dao = null;

	private IGenericDAO<SimpleBaseEntityBean, String> simpleDao = null;

	public IGenericDAO<SimpleBaseEntityBean, String> getSimpleDao() {
		return simpleDao;
	}

	public void setSimpleDao(IGenericDAO<SimpleBaseEntityBean, String> simpleDao) {
		clazz = simpleDao.getEntityBeanType();
		this.simpleDao = simpleDao;
		jsonResult = new JsonResult<T>();
	}

	private Class clazz = null;

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		jsonResult = new JsonResult<T>();
		this.clazz = clazz;
	}

	public IGenericDAO<BaseEntityBean, String> getDao() {
		return dao;
	}

	public void setDao(IGenericDAO<BaseEntityBean, String> dao) {
		clazz = dao.getEntityBeanType();
		jsonResult = new JsonResult<T>();
		this.dao = dao;
	}

	@Context
	protected HttpServletRequest request;
	private ObjectMapper mapper = new ObjectMapper();;

	public Map get(@QueryParam("id") String id) {
		Map res = new HashMap();

		try {
			Object o = dao.findById(id, false);
			res.put("data", o);
			res.put("success", "true");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			dao.getEntityManager().close();
			return null;
		}
	}

	protected String update(Map map, String model)
			throws JsonGenerationException, JsonMappingException, IOException {

		try {
			String sql = "update " + model + " o set  ";

			// Query query = null;
			Set<String> key = map.keySet();

			for (Iterator it = key.iterator(); it.hasNext();) {
				String propertyName = (String) it.next();
				if (null != map.get(propertyName)
						&& !"".equals(map.get(propertyName).toString())) {

					sql = sql + " o." + propertyName + "=:" + propertyName
							+ ",";
					// query=dao.getEntityManager().createQuery(sql);
					// query.setParameter(propertyName,
					// map.get(propertyName).toString());

				}
			}

			dao.getEntityManager().getTransaction().begin();
			Query query = dao.getEntityManager().createQuery(
					sql.substring(0, sql.length() - 1) + " where o.id=:key");

			for (Iterator it = key.iterator(); it.hasNext();) {
				String propertyName = (String) it.next();
				if (null != map.get(propertyName)
						&& !"".equals(map.get(propertyName).toString())) {

					query.setParameter(propertyName, map.get(propertyName)
							.toString());

				}
			}
			query.setParameter("key", map.get("id"));
			query.executeUpdate();
			dao.getEntityManager().getTransaction().commit();
			jsonResult.setMessage("操作成功!" + "\n");
			// return jsonValid;
		} catch (Exception e) {
			jsonResult.setMessage("服务器异常,操作失败\n");
			e.printStackTrace();
		} finally {
			if (dao.getEntityManager() != null) {
				dao.getEntityManager().close();
			}
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局

		return mapper.writeValueAsString(jsonResult);
	}

	protected String loadBySql(String hql, Object[] values) {
		
//		JSONObject map = JSONObject.fromObject(conStr);
		Query query = dao.getEntityManager().createQuery(hql);
		for(int i=0;i<values.length;i++){
			query.setParameter(i, values[i]);
		}

		List list=query.getResultList();
		
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected String load() {

		String conStr = Tools.getStringParameter(request, "conStr", "");
		// Map map=this.json2Map(conStr);

		JSONObject map = JSONObject.fromObject(conStr);
		String start = Tools.getStringParameter(request, "start", "0");
		String limit = Tools.getStringParameter(request, "limit", "10");
		try {

			DetachedCriteria detachedCrit = dao.createDetachedCriteria();

			detachedCrit
					.add(Restrictions.eq("deleteFlag", CONSTANT_VALID_FLAG));

			Set<String> key = map.keySet();
			for (Iterator it = key.iterator(); it.hasNext();) {
				String propertyName = (String) it.next();
				if (null != map.get(propertyName)
						&& !"".equals(map.get(propertyName).toString())) {
					String value = "%"
							+ map.get(propertyName).toString()
									.replaceAll("\\[", "")
									.replaceAll("\\]", "") + "%";
					detachedCrit.add(Restrictions.like(propertyName, value,
							MatchMode.ANYWHERE));
				}
			}
//			detachedCrit.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
			Session session = (Session) dao.getEntityManager().getDelegate();

			Criteria criteria = detachedCrit.getExecutableCriteria(session);
			
			
			long totalCount = ((Long) criteria.setProjection(
					Projections.rowCount()).uniqueResult()).longValue();
			criteria.setProjection(null);

			
			detachedCrit.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
//			Criteria criteriaFind = detachedCrit.getExecutableCriteria(session);
			
			List list = criteria.setFirstResult(Integer.valueOf(start))
					.setMaxResults(Integer.valueOf(limit)).list();

			// List list = dao.findByDetachedCriteria(detachedCrit);

			jsonResult.setTotal(totalCount);
			jsonResult.setRoot(list);
			jsonResult.build(clazz);
			// jr.build(entityBeanType.c);

			jsonResult.setMessage("本次查询数量" + totalCount + "当前页面显示为"
					+ list.size() + "\n");
			mapper = new ObjectMapper();

			mapper.configure(
					SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
					false);// 封闭时候戳输出，此时是ISO格局
			return mapper.writeValueAsString(jsonResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dao.getEntityManager() != null) {
				dao.getEntityManager().close();
			}
		}
		// BeanUtils.setProperty(bean, name, value)
		return null;
	}

	public String deleteSimple(String id) throws Exception {

		try {
			simpleDao.getEntityManager().getTransaction().begin();

			SimpleBaseEntityBean o = simpleDao.findById(id, false);
			o.setDeleteFlag(CONSTANT_INVALID_FLAG);
			simpleDao.makePersistent(o);
			simpleDao.getEntityManager().getTransaction().commit();
			jsonResult.setMessage("操作成功,删除记录" + id + "\n");
		} catch (Exception e) {
			jsonResult.setMessage("服务器异常,操作失败\n");
			e.printStackTrace();
		} finally {
			if (simpleDao.getEntityManager() != null) {
				simpleDao.getEntityManager().close();
			}
		}

		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局

		return mapper.writeValueAsString(jsonResult);
	}

	public String delete(String id) throws Exception {

		try {
			dao.getEntityManager().getTransaction().begin();

			BaseEntityBean o = dao.findById(id, false);
			o.setDeleteFlag(CONSTANT_INVALID_FLAG);
			dao.makePersistent(o);
			dao.getEntityManager().getTransaction().commit();
			jsonResult.setMessage("操作成功,删除记录" + id + "\n");
		} catch (Exception e) {
			jsonResult.setMessage("服务器异常,操作失败\n");
			e.printStackTrace();
		} finally {
			if (dao.getEntityManager() != null) {
				dao.getEntityManager().close();
			}
		}

		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局

		return mapper.writeValueAsString(jsonResult);
	}

	public String saveSimple(SimpleBaseEntityBean o) throws Exception {

		if (o.isNew()) {

			o.setId(UUID.randomUUID().toString());

		}

		try {
			simpleDao.getEntityManager().getTransaction().begin();
			simpleDao.makePersistent(o);
			simpleDao.getEntityManager().getTransaction().commit();
			jsonResult.setMessage("操作成功!" + "\n");
			// return jsonValid;
		} catch (Exception e) {
			jsonResult.setMessage("服务器异常,操作失败\n");
			e.printStackTrace();
		} finally {
			if (simpleDao.getEntityManager() != null) {
				simpleDao.getEntityManager().close();
			}
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局

		return mapper.writeValueAsString(jsonResult);

	}

	public String save(BaseEntityBean o) throws Exception {

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

		try {
			dao.getEntityManager().getTransaction().begin();
			dao.makePersistent(o);
			dao.getEntityManager().getTransaction().commit();
			jsonResult.setMessage("操作成功!" + "\n");
			// return jsonValid;
		} catch (Exception e) {
			jsonResult.setMessage("服务器异常,操作失败\n");
			e.printStackTrace();
		} finally {
			if (dao.getEntityManager() != null) {
				dao.getEntityManager().close();
			}
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局

		return mapper.writeValueAsString(jsonResult);

	}

}
