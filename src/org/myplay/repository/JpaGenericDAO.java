package org.myplay.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.itgodo.common.ConnHelper;

/**
 * Implements the generic CRUD data access operations using Java Persistence APIs.
 * <p>
 * To write a DAO, subclass and parameterize this class with your entity. Of course, assuming that you have a
 * traditional 1:1 appraoch for Entity:DAO design. This is actually an implementation that uses some extensions for Java
 * Persistence from Hibernate - you can see how the packages for the extensions are not imported, but named inline.
 * 
 * @author Christian Bauer
 */

@SuppressWarnings("unchecked")
public class JpaGenericDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {
	static Logger log = Logger.getLogger(JpaGenericDAO.class);
	private Class<T> entityBeanType;

	private String dsName;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("wanli_ds");

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	private EntityManager em = getEntityManagerFactory().createEntityManager();

	public JpaGenericDAO() {
		this.entityBeanType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public JpaGenericDAO(Class<T> clazz) {
		this.entityBeanType = clazz;

	}

	public JpaGenericDAO(Class<T> clazz, String pu) {

		this.entityBeanType = clazz;
		em.close();

		// emf.close();
		// emf = Persistence
		// .createEntityManagerFactory(pu);

	}

	public List<T> executeNativeQuery(String sql) {
		try {
			EntityManager newEm = emf.createEntityManager();
			EntityTransaction newTx = newEm.getTransaction();
			newTx.begin();
			em.createNativeQuery(sql, getEntityBeanType());
			List<T> stu = newEm.createNativeQuery(sql, getEntityBeanType()).getResultList();
			newTx.commit();
			newEm.close();
			return stu;

		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return null;
	}

	public Object executeNativeQuery(String sql, Class<T> clazz) {
		try {
			EntityManager newEm = emf.createEntityManager();
			EntityTransaction newTx = newEm.getTransaction();
			newTx.begin();
			em.createNativeQuery(sql);

			Object stu = newEm.createNativeQuery(sql).getSingleResult();
			newTx.commit();
			newEm.close();
			return stu;

		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		return null;
	}

	public boolean nativeUpdate(String sql) throws SQLException, Exception {
		boolean execute = false;
		Connection conn = ConnHelper.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		execute = ps.execute();
		ps.close();
		conn.close();
		return execute;

	}

	/**
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> nativeQuery(StringBuffer sql) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(0);
		Connection conn = ConnHelper.getConnection();
		if (null != conn) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql.toString());
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			int i = 1;
			Map<String, Object> result = null;
			while (rs.next()) {
				result = new HashMap<String, Object>(0);
				for (i = 1; i <= cols; i++) {
					result.put(null == rsmd.getColumnLabel(i) ? rsmd.getColumnName(i) : rsmd.getColumnLabel(i),
							rs.getObject(i));
				}
				list.add(result);
			}
			rs.close();
			st.close();
			conn.close();
		}
		return list;

	}

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		if (em == null)
			throw new IllegalStateException("EntityManager has not been set on DAO before usage");
		return em;
	}

	@Override
	public Class<T> getEntityBeanType() {
		if (entityBeanType == null)
			this.entityBeanType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		return entityBeanType;
	}

	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = getEntityManager().find(getEntityBeanType(), id);
			em.lock(entity, javax.persistence.LockModeType.WRITE);
		} else {
			entity = getEntityManager().find(getEntityBeanType(), id);
		}
		return entity;
	}

	public T makePersistent(T entity) {
		return getEntityManager().merge(entity);
	}

	public void makeTransient(T entity) {
		entity = getEntityManager().merge(entity);
		getEntityManager().remove(entity);
	}

	public void flush() {
		getEntityManager().flush();
	}

	public void clear() {
		getEntityManager().clear();
	}

	public List<T> findAll() {
		return getEntityManager().createQuery("from " + getEntityBeanType().getName()).getResultList();
	}

	public Query query(String q) {
		Query query = em.createQuery(q);
		return query;
	}

	public List<T> findByCriteria(org.hibernate.criterion.Criterion... criterion) {
		return findByCriteriaExamplePage(0, -1, null, null, false, criterion).getData();
	}

	public List<T> findByCriteriaExample(T exampleInstance, org.hibernate.criterion.Criterion... criterion) {
		return findByCriteriaExamplePage(0, -1, exampleInstance, null, false, criterion).getData();
	}

	public List<T> findByCriteriaExamplePage(int startIndex, int limit, T exampleInstance,
			List<KeyValue<Boolean>> orders, org.hibernate.criterion.Criterion... criterion) {
		return findByCriteriaExamplePage(startIndex, limit, exampleInstance, orders, false, criterion).getData();
	}

	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		// Using Hibernate, more difficult with EntityManager and EJB-QL
		org.hibernate.Criteria crit = ((org.hibernate.ejb.HibernateEntityManager) getEntityManager()).getSession()
				.createCriteria(getEntityBeanType());
		org.hibernate.criterion.Example example = org.hibernate.criterion.Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	public CommonResult<T> findByCriteriaExamplePage(int startIndex, int limit, T exampleInstance,
			List<KeyValue<Boolean>> orders, boolean bTotalCount, Criterion... criterion) {

		org.hibernate.Criteria crit = ((org.hibernate.ejb.HibernateEntityManager) getEntityManager()).getSession()
				.createCriteria(getEntityBeanType());

		// criteria
		for (org.hibernate.criterion.Criterion c : criterion) {
			crit.add(c);
		}

		// example
		if (exampleInstance != null) {
			org.hibernate.criterion.Example example = org.hibernate.criterion.Example.create(exampleInstance);
			crit.add(example);
		}

		int count = 0;
		if (bTotalCount == true) {
			org.hibernate.Criteria critCount = ((org.hibernate.ejb.HibernateEntityManager) getEntityManager())
					.getSession().createCriteria(getEntityBeanType());
			// criteria
			for (org.hibernate.criterion.Criterion c : criterion) {
				critCount.add(c);
			}
			// example
			if (exampleInstance != null) {
				org.hibernate.criterion.Example example = org.hibernate.criterion.Example.create(exampleInstance);
				critCount.add(example);
			}
			count = ((Number) critCount.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			System.out.println("Total count is: " + count);
		}

		// page
		if (limit > 0) {
			crit.setMaxResults(limit);
			crit.setFirstResult(startIndex);
		}

		// sort
		if (orders != null) {
			for (KeyValue<Boolean> orderBy : orders) {
				if (orderBy.getValue()) {
					crit.addOrder(Order.asc(orderBy.getKey()));
				} else {
					crit.addOrder(Order.desc(orderBy.getKey()));
				}
			}
		}
		return new CommonResult<T>(count, crit.list(), startIndex);

	}

	public void delete(T entity) {
		getEntityManager().remove(entity);
	}

	public List<T> executeQuery(String q) {
		return query(q).getResultList();
	}

	public int executeUpdate(String q) {
		return query(q).executeUpdate();
	}

	// TODO Auto-generated method stub
	public DetachedCriteria createDetachedCriteria() {
		// TODO Auto-generated method stub
		return DetachedCriteria.forClass(this.entityBeanType);
	}

	public List<T> findByDetachedCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return criteria.getExecutableCriteria(
				((org.hibernate.ejb.HibernateEntityManager) getEntityManager()).getSession()).list();
	}

	public CommonResult<T> findByDetachedCriteriaExamplePage(int startIndex, int limit, List<KeyValue<Boolean>> orders,
			boolean bTotalCount, DetachedCriteria detachedCriteria) {
		Criteria crit = detachedCriteria
				.getExecutableCriteria(((org.hibernate.ejb.HibernateEntityManager) getEntityManager()).getSession());

		// org.hibernate.Criteria crit =
		// ((org.hibernate.ejb.HibernateEntityManager) getEntityManager())
		// .getSession().createCriteria(getEntityBeanType());

		// criteria
		// for (org.hibernate.criterion.Criterion c : criterion) {
		// crit.add(c);
		// }

		// example
		// if (exampleInstance != null) {
		// org.hibernate.criterion.Example example =
		// org.hibernate.criterion.Example
		// .create(exampleInstance);
		// crit.add(example);
		// }
		int count = 0;
		if (bTotalCount == true) {
			// org.hibernate.Criteria critCount =
			// ((org.hibernate.ejb.HibernateEntityManager) getEntityManager())
			// .getSession().createCriteria(getEntityBeanType());
			// criteria
			// for (org.hibernate.criterion.Criterion c : criterion) {
			// critCount.add(c);
			// }
			// // example
			// if (exampleInstance != null) {
			// org.hibernate.criterion.Example example =
			// org.hibernate.criterion.Example
			// .create(exampleInstance);
			// critCount.add(example);
			// }
			count = ((Number) crit.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			System.out.println("Total count is: " + count);
		}

		// page
		if (limit > 0) {
			crit.setMaxResults(limit);
			crit.setFirstResult(startIndex);
		}

		// sort
		if (orders != null) {
			for (KeyValue<Boolean> orderBy : orders) {
				if (orderBy.getValue()) {
					crit.addOrder(Order.asc(orderBy.getKey()));
				} else {
					crit.addOrder(Order.desc(orderBy.getKey()));
				}
			}
		}
		return new CommonResult<T>(count, crit.list(), startIndex);

	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public void save(T entity) {
		getEntityManager().persist(entity);

	}

}
