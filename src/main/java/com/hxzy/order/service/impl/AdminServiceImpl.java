package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.AdminDao;
import com.hxzy.order.dto.AdminDto;
import com.hxzy.order.model.Admin;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		adminDao.delete(ids);		
	}

	@Override
	public void update(Admin admin) {
		if(admin.getId() == null || admin.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = adminDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			admin.setId("A" + date + String.valueOf(count));
			adminDao.add(admin);
		}else{
			/*修改*/
			adminDao.update(admin);
		}
	}

	@Override
	public List<Admin> query(Page<AdminDto> page) {
		return adminDao.query(page);
	}

	@Override
	public Admin queryById(String id) {
		return adminDao.queryById(id);
	}

	@Override
	public int count(AdminDto adminDto) {
		return adminDao.count(adminDto);
	}

	@Override
	public Admin exist(Admin admin) {
		return adminDao.exist(admin);
	}

	@Override
	public boolean checkName(String username) {
		return adminDao.checkName(username);
	}

	@Override
	public void loginRecord(Admin admin) {
		admin.setLoginCount(admin.getLoginCount() + 1);
		update(admin);
	}

}
