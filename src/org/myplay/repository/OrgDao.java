package org.myplay.repository;

import java.util.List;

import org.myplay.entity.Organization;
import org.myplay.web.ComboVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrgDao extends
		PagingAndSortingRepository<Organization, String> {
	@Query(" select o from Organization o where o.parentOrganizationId = null and type=? and  o.deleteFlag=0")
	List<Organization> findRoot(String type);

	@Query(" select o from Organization o where o.deleteFlag=0")
	List<Organization> findAllOrg();

	@Query(" select o.id,o.name from Organization o where o.type  ='1' and o.parentOrganizationId = (select id from  Organization where parentOrganizationId =null)")
	/**
	 * 第一层用车单位
	 * @return
	 */
	List<Object[]> findOrgByType();

	/**
	 * 用车单位的子机构
	 * 
	 * @param parent
	 * @return
	 */
	@Query(" select  new org.myplay.web.ComboVo(o.id,o.name) from Organization o where o.type  ='1' and o.parentOrganizationId = ?")
	List<ComboVo> findOrgByType(String parent);

	@Query(" select o from Organization o where o.type='2' and o.id in ( select dispatchDepartID from DepartmentStruc )")
	List<Organization> findBindedOrg();
	
	@Query(" select o from Organization o where o.type='2' and o.id not in ( select dispatchDepartID from DepartmentStruc )")
	List<Organization> findUnBindedOrg();
}
