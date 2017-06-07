package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.dto.AdminDto;
import com.hxzy.order.model.Admin;
import com.hxzy.order.page.Page;

public interface AdminDao {
	void add(Admin admin);

	void delete(String ids);

	void update(Admin admin);

	List<Admin> query(Page<AdminDto> page);

	Admin queryById(String id);

	int count(AdminDto adminDto);

	Admin exist(Admin admin);

	boolean checkName(String username);
	
	int dayCount(String date);
}
