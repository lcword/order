package com.hxzy.order.controller;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Admin;
import com.hxzy.order.service.intf.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("pre_add_admin")
	public String pre_add() {
		return "update_admin";
	}

	@RequestMapping("pre_update_admin")
	public String pre_update(Admin admin,Map<String,Admin> map) {
		map.put("admin", adminService.queryById(admin.getId()));
		return "update_admin";
	}

	@RequestMapping("update_admin")
	public String update(Admin admin) {
		System.out.println("update >>>");
		System.out.println(admin);
		adminService.update(admin);
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
