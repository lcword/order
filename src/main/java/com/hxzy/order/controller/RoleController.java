package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.order.model.Function;
import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.FunctionService;
import com.hxzy.order.service.intf.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private FunctionService functionService;
	
	@RequestMapping("pre_add_role")
	public String pre_add(Map<String,List<Function>> map) {
		map.put("function_list", functionService.query(new Page(1, 1)));
		return "update_role";
	}

	@RequestMapping("pre_update_role")
	public String pre_update(Role role,Map<String,Object> map) {
		map.put("role", roleService.queryById(role.getId()));
		map.put("function_list", functionService.query(new Page(1, 1)));
		return "update_role";
	}

	@RequestMapping("update_role")
	public String update(Role role,String functionId) {
		roleService.update(role,functionId);
		return "redirect:query_role";
	}

	@RequestMapping("delete_role")
	public String delete(String id) {
		roleService.delete(id);
		return "redirect:query_role";
	}

}
