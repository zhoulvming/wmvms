package org.myplay.entity;

import java.util.List;

public abstract class IJsonResult<T> {

	public IJsonResult() {

		// clazz = (Class<T>) ((ParameterizedType) getClass()
		// .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Class<T> clazz = null;

	public abstract void build();

	/**
	 * 继承与基类对象,按自然排列顺序
	 * 
	 * @param clazz
	 */
	public abstract void build(Class<T> clazz);

	public abstract void setTotal(long total);

	public abstract void setRoot(List<T> list);

	public abstract Object getMessage();

	public abstract void setMessage(Object message);

	public abstract List<T> getRoot();

	/**
	 * 使用用户自定义seq
	 * 
	 * @param clazz
	 */
	public abstract void buildSelfSeq(Class clazz);

	/**
	 * 按自然排列顺序
	 * 
	 * @param clazz
	 */
	public abstract void buildSelf(Class clazz);

}