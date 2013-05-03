package org.myplay.repository;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;

/**
 * An interface shared by all business data access objects.
 * <p>
 * All CRUD (create, read, update, delete) basic data access operations are isolated in this interface and shared
 * accross all DAO implementations. The current design is for a state-management oriented persistence layer (for
 * example, there is no UDPATE statement function) that provides automatic transactional dirty checking of business
 * objects in persistent state.
 * 
 * @author Christian Bauer
 */
public interface IGenericDAO<T, ID extends Serializable> {

	EntityManager getEntityManager();

	void setEntityManager(EntityManager em);

	T findById(ID id, boolean lock);

	List<T> findAll();

	List<T> findByExample(T exampleInstance, String... excludeProperty);

	List<T> findByCriteria(org.hibernate.criterion.Criterion... criterion);

	List<T> findByCriteriaExample(T exampleInstance, org.hibernate.criterion.Criterion... criterion);

	public DetachedCriteria createDetachedCriteria();

	public List<T> findByDetachedCriteria(DetachedCriteria criteria);

	List<T> findByCriteriaExamplePage(int startIndex, int limit, T exampleInstance, List<KeyValue<Boolean>> orders,
			org.hibernate.criterion.Criterion... criterion);

	CommonResult<T> findByCriteriaExamplePage(int startIndex, int limit, T exampleInstance,
			List<KeyValue<Boolean>> orders, boolean bTotalCount, Criterion... criterion);

	T makePersistent(T entity);

	void save(T entity);

	void makeTransient(T entity);

	Query query(String q);

	List<T> executeQuery(String q);

	int executeUpdate(String q);

	List<T> executeNativeQuery(String sql);

	Object executeNativeQuery(String sql, Class<T> clazz);

	public boolean nativeUpdate(String sql) throws SQLException, Exception;

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> nativeQuery(StringBuffer sql) throws Exception;

	public CommonResult<T> findByDetachedCriteriaExamplePage(int startIndex, int limit, List<KeyValue<Boolean>> orders,
			boolean bTotalCount, DetachedCriteria detachedCriteria);

	public abstract Class<T> getEntityBeanType();
}
