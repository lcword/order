package com.hxzy.order.service.impl;

import java.util.List;

import com.hxzy.order.dao.intf.AdminDao;
import com.hxzy.order.dto.AdminDto;
import com.hxzy.order.model.Admin;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.AdminService;

public class AdminServiceImpl implements AdminService{
	private AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void add(Admin admin) {
		adminDao.add(admin);
	}

	@Override
	public void delete(String ids) {
		adminDao.delete(ids);		
	}

	@Override
	public void update(Admin admin) {
		adminDao.update(admin);
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
