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
import org.myplay.entity.JsonResult;
import org.myplay.entity.Organization;
import org.myplay.entity.User;
import org.myplay.service.AccountService;
import org.myplay.service.OrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 用户管理
 * 
 * 
 * 
 * @author peter
 */

@Path("/org")
public class OrgResource {

	private static Logger logger = LoggerFactory.getLogger(OrgResource.class);

	ObjectMapper mapper = new ObjectMapper();
	@Context
	protected HttpServletResponse res;
	@Context
	protected HttpServletRequest req;
	@Context
	ServletContext servletContex;
	protected AccountService accountService;

	protected OrgService orgService;

	public OrgService getOrgService() {
		return orgService;
	}

	@Autowired
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public <T> T getBean(String name, Class<T> clazz) {

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContex);
		return ctx.getBean(name, clazz);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JSONArray getchild(List<Organization> dataList, Organization org) {
		// 递归获取字几点
		JSONArray child = new JSONArray();

		for (Organization o : dataList) {
			if (org.getId().equals(o.getParentOrganizationId())) {

				Map childjson = new HashMap();
				childjson.put("id", o.getId());
				childjson.put("text", o.getName());
				JSONArray childs = getchild(dataList, o);
				if (childs.size() > 0) {
					childjson.put("children", childs);
				} else {
					childjson.put("leaf", "true");
				}

				child.add(childjson);

			}
		}

		return child;
	}

	public String tree() throws IOException {
		JSONArray root = new JSONArray();
		// 检索数据库获取数据 select nodeid,nodename,parent_id from table
		orgService = this.getBean("orgService", OrgService.class);
		List<Organization> dataList = orgService.findAll();
		List<Organization> rootOrg = orgService.findRoot(req.getParameter(
				"type").toString());
		for (Organization o : rootOrg) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", o.getId());
			map.put("text", o.getName());

			JSONArray child = getchild(dataList, o);
			map.put("children", child);
			root.add(map);

		}

		root.toJSONObject(root);

		return root.toString();
	}

	@GET
	@Path("/loadOrg")
	@Produces(MediaType.APPLICATION_JSON)
	public String loadOrg() throws JsonGenerationException,
			JsonMappingException, IOException {

		return tree();
	}

	@GET
	@Path("/getBindedOrg")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBindedOrg(@QueryParam("model") String model)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<Organization> jsonResult = new JsonResult<Organization>();
		try {
			orgService = this.getBean("orgService", OrgService.class);
			List list = orgService.findBindedOrg(model);
			jsonResult.setRoot(list);
			jsonResult.build(Organization.class);
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
	@Path("/getComboOrg")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComboOrg(@QueryParam("parent") String parent)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<ComboVo> jsonResult = new JsonResult<ComboVo>();
		try {
			orgService = this.getBean("orgService", OrgService.class);
			List<ComboVo> list = null;
			// if(level.equals("1")){
			// list = orgService.findOrgByType();
			// }
			// if(level.equals("2")){
			if (null!=parent&&parent.equals("null")){
				
				list=orgService.findOrgByType();
			}else{
				
				list = orgService.findOrgByType(parent);
			}
			
			// }
			// List res = new ArrayList();
			// for (Object[] kv : list) {
			// ComboVo vo = new ComboVo(kv[0].toString(), kv[1].toString());
			// res.add(vo);
			// }
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
	@Path("/bindOrg")
	@Produces(MediaType.APPLICATION_JSON)
	public String bindOrg(@QueryParam("scrOrgId") String scrOrgId,
			@QueryParam("desOrgId") String desOrgId)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<User> jsonResult = new JsonResult<User>();
		try {

			orgService = this.getBean("orgService", OrgService.class);
			String[] arr = desOrgId.split(",");
			for (String orgId : arr) {

				orgService.bindOrg(scrOrgId, orgId);
			}

			jsonResult.setSuccess(true);

			jsonResult.setMessage("保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("保存失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}

	@POST
	@Path("/addOrg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addOrg(Organization org,
			@QueryParam("parentId") String parentId)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<User> jsonResult = new JsonResult<User>();
		try {

			orgService = this.getBean("orgService", OrgService.class);
			orgService.saveOrg(org, parentId);

			jsonResult.setSuccess(true);

			jsonResult.setMessage("保存成功!");

		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("保存失败!");
		}
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult);
	}

}
