package org.myplay.web;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.myplay.entity.SimpleBaseEntityBean;
import org.myplay.repository.IGenericDAO;
import org.myplay.repository.JpaGenericDAO;

@SuppressWarnings("rawtypes")
@Path("/simplecommon")
public class SimpleCommonResource extends AbstractBaseResource {
	private static final String ENTITY_PACK_PREFIX = "org.myplay.entity.";

	@SuppressWarnings("unchecked")
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Map get(@QueryParam("model") String model,
			@QueryParam("id") String id) {

		model = ENTITY_PACK_PREFIX + model;

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			IGenericDAO<SimpleBaseEntityBean, String> dao = new JpaGenericDAO<SimpleBaseEntityBean, String>(
					clazz);

			super.setDao(dao);

			return super.get(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	// Delete
	@GET
	@Path("/del")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@QueryParam("model") String model,
			@QueryParam("id") String id) throws Exception {

		model = ENTITY_PACK_PREFIX + model;

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			IGenericDAO<SimpleBaseEntityBean, String> dao = new JpaGenericDAO<SimpleBaseEntityBean, String>(
					clazz);

			super.setSimpleDao(dao);

			return super.deleteSimple(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes("application/x-www-form-urlencoded")
	@javax.ws.rs.Encoded
	// public String load(MultivaluedMap<String, String> map) throws Exception {
	public String update(Map map) throws Exception {
		String model = request.getParameter("model");
		model = ENTITY_PACK_PREFIX + model;

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			IGenericDAO<SimpleBaseEntityBean, String> dao = new JpaGenericDAO<SimpleBaseEntityBean, String>(
					clazz);

			super.setDao(dao);

			return super.update(map, model);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@GET
	@Path("/load")
	@Produces(MediaType.APPLICATION_JSON)
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Consumes("application/x-www-form-urlencoded")
	@javax.ws.rs.Encoded
	// public String load(MultivaluedMap<String, String> map) throws Exception {
	public String load() {
		String model = request.getParameter("model");
		model = ENTITY_PACK_PREFIX + model;

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			IGenericDAO<SimpleBaseEntityBean, String> dao = new JpaGenericDAO<SimpleBaseEntityBean, String>(
					clazz);

			super.setDao(dao);

			return super.load();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String save(Map map) throws Exception {

		String model = request.getParameter("model");
		model = ENTITY_PACK_PREFIX + model;
		SimpleBaseEntityBean o = (SimpleBaseEntityBean) Class.forName(model)
				.newInstance();
		BeanUtils.populate(o, map);

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			IGenericDAO<SimpleBaseEntityBean, String> dao = new JpaGenericDAO<SimpleBaseEntityBean, String>(
					clazz);

			super.setSimpleDao(dao);

			return super.saveSimple(o);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
