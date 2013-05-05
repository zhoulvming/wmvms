package org.myplay.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.myplay.entity.BaseEntityBean;
import org.myplay.entity.JsonResult;
import org.myplay.repository.IGenericDAO;
import org.myplay.repository.JpaGenericDAO;
import org.myplay.service.CommonService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("rawtypes")
@Path("/common")
public class CommonResource extends AbstractBaseResource {
	private static final String ENTITY_PACK_PREFIX = "org.myplay.entity.";
	protected CommonService commonService;
	@Context
	ServletContext servletContex;
	ObjectMapper mapper = new ObjectMapper();
	public <T> T getBean(String name, Class<T> clazz, ServletContext servletContex) {

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContex);
		return ctx.getBean(name, clazz);
	}
	@GET
	@Path("/findTaskTypeCombo")
	@Produces(MediaType.APPLICATION_JSON)
	public String findTaskTypeCombo()
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<ComboVo> jsonResult = new JsonResult<ComboVo>();
		try {
			commonService = this.getBean("commonService",
					CommonService.class, servletContex);
			List<ComboVo> list = commonService.findTaskTypeCombo();
			jsonResult.setRoot(list);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("加载成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("加载失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}
	@GET
	@Path("/findAddressCombo")
	@Produces(MediaType.APPLICATION_JSON)
	public String findAddressCombo()
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<ComboVo> jsonResult = new JsonResult<ComboVo>();
		try {
			commonService = this.getBean("commonService",
					CommonService.class, servletContex);
			List<ComboVo> list = commonService.findAddressCombo();
			jsonResult.setRoot(list);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("加载成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("加载失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}
	@GET
	@Path("/findCarCombo")
	@Produces(MediaType.APPLICATION_JSON)
	public String findCarCombo(@QueryParam("parent") String parent)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<ComboVo> jsonResult = new JsonResult<ComboVo>();
		try {
			commonService = this.getBean("commonService",
					CommonService.class, servletContex);
			List<ComboVo> list = commonService.findCarCombo();

			jsonResult.setRoot(list);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("加载成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("加载失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}
	@GET
	@Path("/findDriverCombo")
	@Produces(MediaType.APPLICATION_JSON)
	public String findDriverCombo(@QueryParam("parent") String parent)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<ComboVo> jsonResult = new JsonResult<ComboVo>();
		try {
			commonService = this.getBean("commonService",
					CommonService.class, servletContex);
			List<ComboVo> list = commonService.findDriverCombo();

			jsonResult.setRoot(list);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("加载成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("加载失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}
	@GET
	@Path("/findCarModelCombo")
	@Produces(MediaType.APPLICATION_JSON)
	public String findCarModelCombo(@QueryParam("parent") String parent)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<ComboVo> jsonResult = new JsonResult<ComboVo>();
		try {
			commonService = this.getBean("commonService",
					CommonService.class, servletContex);
			List<ComboVo> list = commonService.findCarModelCombo();

			jsonResult.setRoot(list);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("加载成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("加载失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}

	@GET
	@Path("/getSearchField")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSearchField(@QueryParam("model") String model)
			throws Exception {

		model = ENTITY_PACK_PREFIX + model;

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			super.setClazz(clazz);
			return super.getSearchField();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

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
			IGenericDAO<BaseEntityBean, String> dao = new JpaGenericDAO<BaseEntityBean, String>(
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
			IGenericDAO<BaseEntityBean, String> dao = new JpaGenericDAO<BaseEntityBean, String>(
					clazz);

			super.setDao(dao);

			return super.delete(id);
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
			IGenericDAO<BaseEntityBean, String> dao = new JpaGenericDAO<BaseEntityBean, String>(
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
			IGenericDAO<BaseEntityBean, String> dao = new JpaGenericDAO<BaseEntityBean, String>(
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
		BaseEntityBean o = (BaseEntityBean) Class.forName(model).newInstance();
		BeanUtils.populate(o, map);

		Class clazz = null;
		try {
			clazz = Class.forName(model);
			IGenericDAO<BaseEntityBean, String> dao = new JpaGenericDAO<BaseEntityBean, String>(
					clazz);

			super.setDao(dao);

			return super.save(o);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
