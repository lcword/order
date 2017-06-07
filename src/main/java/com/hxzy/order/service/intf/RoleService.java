package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;

public interface RoleService {
	void delete(String ids);

	void update(Role role);

	List<Role> query(Page page);

	Role queryById(String id);
}
