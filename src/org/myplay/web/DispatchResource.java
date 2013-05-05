package org.myplay.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.myplay.entity.Apply;
import org.myplay.entity.Assign;
import org.myplay.entity.JsonResult;
import org.myplay.entity.Organization;
import org.myplay.entity.User;
import org.myplay.service.AccountService;
import org.myplay.service.DispatchService;
import org.myplay.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 调度管理
 * 
 * @author Zhou.lvming
 */

@Path("/dispatch")
public class DispatchResource {

	private static Logger logger = LoggerFactory.getLogger(DispatchResource.class);

	ObjectMapper mapper = new ObjectMapper();
	@Context
	protected HttpServletResponse res;
	@Context
	protected HttpServletRequest req;
	@Context
	ServletContext servletContex;
	
	protected DispatchService dispatchService;
	public DispatchService getDispatchService() {
		return dispatchService;
	}
	@Autowired
	public void setDispatchService(DispatchService dispatchService) {
		this.dispatchService = dispatchService;
	}
	
	public <T> T getBean(String name, Class<T> clazz) {
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContex);
		return ctx.getBean(name, clazz);
	}
	
	@POST
	@Path("/addAssign")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addAssign(Assign assign) throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<User> jsonResult = new JsonResult<User>();
		try {
			dispatchService = this.getBean("dispatchService", DispatchService.class);
			dispatchService.addAssign(assign);
			jsonResult.setSuccess(true);
			jsonResult.setMessage("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);
			jsonResult.setMessage("保存失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}
	
	@POST
	@Path("/searchApply")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String searchApply(@QueryParam("status") String status) 
			throws JsonGenerationException, JsonMappingException, IOException {

		JSONArray root = new JSONArray();
		dispatchService = this.getBean("dispatchService", DispatchService.class);
		List<Apply> dataList = dispatchService.searchApply(Integer.parseInt(status));
		for (Apply o : dataList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", o.getId());
			map.put("applyStatus", o.getApplyStatus());
			root.add(map);
			
//			root.add(o);
		}

		root.toJSONObject(root);
		return root.toString();
	}

}
