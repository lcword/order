package com.hxzy.order.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Admin;
import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.AdminService;
import com.hxzy.order.service.intf.RoleService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("pre_add_admin")
	public String pre_add(Map<String,List<Role>> map) {
		map.put("role_list", roleService.query(new Page(1, 1)));
		return "update_admin";
	}

	@RequestMapping("pre_update_admin")
	public String pre_update(Admin admin,Map<String,Object> map) {
		map.put("admin", adminService.queryById(admin.getId()));
		map.put("role_list", roleService.query(new Page(1, 1)));
		return "update_admin";
	}

	@RequestMapping("update_admin")
	public String update(Admin admin,String roleId) {
		adminService.update(admin,roleId);
		return "redirect:query_admin";
	}

	@RequestMapping("delete_admin")
	public String delete(String id) {
		adminService.delete(id);
		return "redirect:query_admin";
	}

	@RequestMapping("check_username")
	public void checkUserName(String username,PrintWriter pw) {
		boolean flog = adminService.checkName(username);
		if (flog) {
			pw.print("{\"message\":\"yes\"}");
		} else {
			pw.print("{\"message\":\"no\"}");
		}
	}

}
