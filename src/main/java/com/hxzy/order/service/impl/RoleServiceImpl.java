package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.RoleDao;
import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.RoleService;

@Service("roleServcie")
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		roleDao.delete(ids);
	}

	@Override
	public void update(Role role) {
		if(role.getId() == null || role.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = roleDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			role.setId("R" + date + String.valueOf(count));
			roleDao.add(role);
		}else{
			/*修改*/
			roleDao.update(role);
		}
	}

	@Override
	public List<Role> query(Page page) {
		return roleDao.query(page);
	}

	@Override
	public Role queryById(String id) {
		return roleDao.queryById(id);
	}

}
