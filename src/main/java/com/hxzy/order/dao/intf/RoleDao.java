package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;

public interface RoleDao {
	void add(Role role);

	void delete(String ids);

	void update(Role role);

	List<Role> query(Page page);
	
	Role queryById(String id);
	
	int dayCount(String date);
}
