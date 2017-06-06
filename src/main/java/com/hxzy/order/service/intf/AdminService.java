package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.dto.AdminDto;
import com.hxzy.order.model.Admin;
import com.hxzy.order.page.Page;

public interface AdminService {
	void add(Admin admin);

	void delete(String ids);

	void update(Admin admin);

	List<Admin> query(Page<AdminDto> page);

	Admin queryById(String id);

	int count(AdminDto adminDto);

	Admin exist(Admin admin);

	boolean checkName(String adminname);
	
	void loginRecord(Admin admin);
}
