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

	@RequestMapping("pre_add_user")
	public String pre_add() {
		return "update_frame";
	}

	@RequestMapping("pre_update_user")
	public String pre_update(Admin admin,Map<String,Admin> map) {
		map.put("user", adminService.queryById(String.valueOf(admin.getId())));
		return "update_frame";
	}

	@RequestMapping("update_user")
	public String update(Admin admin) {
		adminService.update(admin);
		return "redirect:query_admin";
	}

	@RequestMapping("delete_user")
	public String delete(Admin admin) {
		adminService.delete(String.valueOf(admin.getId()));
		return "redirect:query_user";
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
