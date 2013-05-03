package org.myplay.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.myplay.entity.JsonResult;
import org.myplay.entity.User;
import org.myplay.util.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * 
 * 真正登录的POST请求由Filter完成,
 * 
 * @author calvin
 */
// @Controller
// @RequestMapping(value = "/login")
@Path("/account")
public class AccountResource {
	
	private static Logger logger = LoggerFactory
			.getLogger(AccountResource.class);
	
	ObjectMapper mapper = new ObjectMapper();
	@Context
	protected HttpServletResponse res;
	@Context
	protected HttpServletRequest req;
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login() throws JsonGenerationException, JsonMappingException, IOException {
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(
				req.getParameter("username"), EncryptUtils.encryptMD5(req.getParameter("password")));
		logger.info(EncryptUtils.encryptMD5(req.getParameter("password")));
		
		JsonResult<User> jsonResult = new JsonResult<User>();
	
//		token.setRememberMe(true);
		try {
			currentUser.login(token);
			
			jsonResult.setSuccess(true);

			jsonResult.setMessage("登陆成功!");
			
		} catch (AuthenticationException e) {
//			modelView.addObject("message", "login errors");
//			modelView.setViewName("/login");
			e.printStackTrace();
			jsonResult.setSuccess(false);

			jsonResult.setMessage("登陆失败!");
		}
		mapper.configure(
				SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);// 封闭时候戳输出，此时是ISO格局
		return mapper.writeValueAsString(jsonResult); 
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public String
	// fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM)
	// String userName, Model model) {
	// model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM,
	// userName);
	// return "account/login";
	// }

}
