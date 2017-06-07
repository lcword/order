package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.RoleService;

@Controller
public class QueryRoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping("query_role")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Role> roleList = roleService.query(page);
		map.put("role_list", roleList);
		map.put("role_page", page);
		return "role_main";
	}
}
