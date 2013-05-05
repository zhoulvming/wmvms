package org.myplay.service;

import java.util.Date;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.myplay.entity.Apply;
import org.myplay.entity.Assign;
import org.myplay.entity.DepartmentStruc;
import org.myplay.entity.Organization;
import org.myplay.repository.DispatchDao;
import org.myplay.repository.OrgBindDao;
import org.myplay.repository.OrgDao;
import org.myplay.web.ComboVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class DispatchService {

	private DispatchDao dispatchDao;
	@Autowired
	public void setDispatchDao(DispatchDao dispatchDao) {
		this.dispatchDao = dispatchDao;
	}

	@Transactional(readOnly = false)
	public void addAssign(Assign assign) {
		assign.setId(UUID.randomUUID().toString());
		
		/**
		 * 业务2位字母 + 4位年份 + 2位月份 + 2位日期 + 4位流水号（流水号每天以0001开始）；
	     * 举例：派车单号：PC201211020001—>2012年11月2日0001编号的派车单
		 */
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String maxSerial = dispatchDao.getMaxSerialID("%" + f.format(now) + "%");
		String newSerial = "PC" + f.format(now);
		if (maxSerial != null) {
			BigInteger a = new BigInteger(maxSerial.substring(2));
			BigInteger c = a.add(new BigInteger("1"));
			String test = String.valueOf(c);
			newSerial = "PC" + test;
		} else {
			newSerial += "0001";
		}
		
		assign.setSerialID(newSerial);
		dispatchDao.save(assign);
	}

	@Transactional(readOnly = false)
	public List<Apply> searchApply(int status) {
		return dispatchDao.searchApply(status);
	}
}
