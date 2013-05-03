package org.myplay.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.myplay.entity.Organization;
import org.myplay.entity.Role;
import org.myplay.entity.User;
import org.myplay.exception.ServiceException;
import org.myplay.repository.OrgDao;
import org.myplay.repository.RoleDao;
import org.myplay.repository.UserDao;
import org.myplay.service.ShiroDbRealm.ShiroUser;
import org.myplay.util.DateProvider;
import org.myplay.util.Digests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户管理类.
 * 
 * @author peter
 */
// Spring Service Bean的标识.
@Component
@Transactional(readOnly = true)
public class AccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory
			.getLogger(AccountService.class);

	private UserDao userDao;

	private RoleDao roleDao;

	private DateProvider dateProvider = DateProvider.DEFAULT;
	





	@Transactional(readOnly = false)
	public void assignRole(List<String> users, List<String> roles) {

		for (String uid : users) {

			User u = userDao.findOne(uid);

			for (String rid : roles) {
				Role r = roleDao.findOne(rid);

				u.getRoles().add(r);

			}
			userDao.save(u);
		}

	}

	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}

	public User getUser(String id) {
		return userDao.findOne(id);
	}

	public User findUserByLoginName(String loginName) {
		return userDao.findByScreenName(loginName);
	}

	@Transactional(readOnly = false)
	public void registerUser(User user) {
		entryptPassword(user);
		// user.setRoles("user");
		// user.setRegisterDate(dateProvider.getDate());

		userDao.save(user);
	}

	@Transactional(readOnly = false)
	public void updateUser(User user) {
		// if (StringUtils.isNotBlank(user.getPlainPassword())) {
		// entryptPassword(user);
		// }
		userDao.save(user);
	}

	@Transactional(readOnly = false)
	public void deleteUser(String id) {
		if (isSupervisor(id)) {
			logger.warn("操作员{}尝试删除超级管理员用户", getCurrentUserName());
			throw new ServiceException("不能删除超级管理员用户");
		}
		userDao.delete(id);

	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(String id) {
		return id.equals("1");
	}

	/**
	 * 取出Shiro中的当前用户LoginName.
	 */
	private String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		// user.setSalt(Encodes.encodeHex(salt));
		//
		// byte[] hashPassword =
		// Digests.sha1(user.getPlainPassword().getBytes(),
		// salt, HASH_INTERATIONS);
		// user.setPassword(Encodes.encodeHex(hashPassword));
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setDateProvider(DateProvider dateProvider) {
		this.dateProvider = dateProvider;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void getRole(String userId) {
		// TODO Auto-generated method stub
		userDao.getRole(userId);
		
	}
}
