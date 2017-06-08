package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Role;
import com.hxzy.order.service.intf.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("pre_add_role")
	public String pre_add() {
		return "update_role";
	}

	@RequestMapping("pre_update_role")
	public String pre_update(Role role,Map<String,Role> map) {
		map.put("role", roleService.queryById(role.getId()));
		return "update_role";
	}

	@RequestMapping("update_role")
	public String update(Role role) {
		roleService.update(role);
		return "redirect:query_role";
	}

	@RequestMapping("delete_role")
	public String delete(String id) {
		roleService.delete(id);
		return "redirect:query_role";
	}

}
