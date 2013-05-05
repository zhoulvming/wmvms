package org.myplay.service;

import java.util.List;
import java.util.UUID;

import org.myplay.entity.DepartmentStruc;
import org.myplay.entity.Organization;
import org.myplay.repository.CommonDao;
import org.myplay.repository.OrgBindDao;
import org.myplay.repository.OrgDao;
import org.myplay.web.ComboVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class OrgService {

	@Autowired
	public void setBindDao(OrgBindDao bindDao) {
		this.bindDao = bindDao;
	}

	private OrgDao orgDao;

	private OrgBindDao bindDao;
	@Autowired
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	private CommonDao commonDao;

	@Autowired
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	@Transactional(readOnly = false)
	public void saveOrg(Organization org, String parentId) {
		// Organization parentOrg = orgDao.findOne(parentId);
		org.setId(UUID.randomUUID().toString());
		// parentOrg.getChildOrgs().add(org);
		// org.setParentOrg(parentOrg);
		org.setParentOrganizationId(parentId);
		orgDao.save(org);

	}

	public List<Organization> findAll() {
//			return orgDao.findAllOrg();
		return commonDao.findAllOrg();
	}

	public List<Organization> findBindedOrg(String model) {

		if (model.equals("1")) {
			return orgDao.findBindedOrg();
		} else {

			return orgDao.findUnBindedOrg();
		}

	}

	public List findOrgByType() {
		return orgDao.findOrgByType();
	}

	public List<ComboVo> findOrgByType(String parent) {
		return orgDao.findOrgByType(parent);
	}

	public List<Organization> findRoot(String type) {
		return orgDao.findRoot(type);
	}

	@Transactional(readOnly = false)
	public void bindOrg(String scrOrgId, String desOrgId) {
		// TODO Auto-generated method stub
		DepartmentStruc o = new DepartmentStruc();
		o.setId(UUID.randomUUID().toString());
		o.setApplyDepartID(scrOrgId);
		o.setDispatchDepartID(desOrgId);
		bindDao.save(o);
		// orgDao.bindOrg(scrOrgId, desOrgId);
	}
}
