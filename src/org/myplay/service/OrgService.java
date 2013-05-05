package org.myplay.service;

import java.util.List;
import java.util.UUID;

import org.myplay.entity.DepartmentStruc;
import org.myplay.entity.Organization;
import org.myplay.repository.CommonRepository;
import org.myplay.repository.OrgDao;
import org.myplay.web.ComboVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class OrgService {

	@Autowired
	private OrgDao orgDao;

	@Autowired
	CommonRepository commonRepository;

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
		return orgDao.findAllOrg();
	}

	public List<Organization> findBindedOrg(String model) {

		if (model.equals("1")) {
			return orgDao.findBindedOrg();
		} else {

			return orgDao.findUnBindedOrg();
		}

	}

	public List findRootOrgByType(String type) {
		return orgDao.findRootOrgByType(type);
	}

	public List<ComboVo> findSubOrgByType(String type,String parent) {
		return orgDao.findSubOrgByType(type,parent);
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

		commonRepository.save(o);
		// orgDao.bindOrg(scrOrgId, desOrgId);
	}
}
