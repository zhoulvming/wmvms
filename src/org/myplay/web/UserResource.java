package org.myplay.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.myplay.entity.JsonResult;
import org.myplay.entity.Role;
import org.myplay.entity.User;
import org.myplay.service.AccountService;
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

@Path("/user")
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);

	ObjectMapper mapper = new ObjectMapper();
	@Context
	protected HttpServletResponse res;
	@Context
	protected HttpServletRequest req;
	@Context
	ServletContext servletContex;
	protected AccountService accountService;

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public <T> T getBean(String name, Class<T> clazz) {

		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(servletContex);
		return ctx.getBean(name, clazz);
	}

	@GET
	@Path("/getRole")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRole(@QueryParam("userId") String userId)
			throws JsonGenerationException, JsonMappingException, IOException {

		JsonResult<Role> jsonResult = new JsonResult<Role>();
		try {

			accountService = this.getBean("accountService",
					AccountService.class);

			// accountService.getRole(userId);

			User user = accountService.getUser(userId);
			Set roles = user.getRoles();
			long totalCount = roles.size();
			List list = new ArrayList();
			list.addAll(roles);
			if (totalCount > 10) {
				jsonResult.setRoot(list.subList(0, 10));
			} else {

				jsonResult.setRoot(list);
			}

			jsonResult.setSuccess(true);
			jsonResult.setTotal(totalCount);
			// jsonResult.setRoot(list);
			jsonResult.build(Role.class);
			jsonResult.setMessage("本次查询数量" + totalCount + "当前页面显示为"
					+ list.size() + "\n");

		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("操作失败!");
		}
		return jsonResult.output();
	}

	@GET
	@Path("/assignRole")
	@Produces(MediaType.APPLICATION_JSON)
	public String assignRole(@QueryParam("userId") List<String> userIds,
			@QueryParam("roleId") List roleIds) throws JsonGenerationException,
			JsonMappingException, IOException {

		JsonResult<User> jsonResult = new JsonResult<User>();
		try {

			ApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(servletContex);
			accountService = ctx
					.getBean("accountService", AccountService.class);
			accountService.assignRole(userIds, roleIds);

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
