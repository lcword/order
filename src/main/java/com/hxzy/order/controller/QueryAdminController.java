package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.dto.AdminDto;
import com.hxzy.order.model.Admin;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.AdminService;

@Controller
public class QueryAdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping("query_admin")
	public String query(Map<String,Object> map,AdminDto adminDto,String type,String curPageStr) {
		int allCount = adminService.count(adminDto);

		Page<AdminDto> page = null;
		if (type != null) {
			int curPage = Integer.parseInt(curPageStr);
			page = new Page<AdminDto>(allCount, curPage);
			if ("prePage".equals(type)) {
				page.setCurPage(page.getPrePage());
			} else if ("nextPage".equals(type)) {
				page.setCurPage(page.getNextPage());
			} else if ("turn".equals(type)) {
				if (curPage < 1) {
					curPage = 1;
				} else if (curPage > page.getMaxPage()) {
					curPage = page.getMaxPage();
				}
				page.setCurPage(curPage);
			}
		} else {
			page = new Page<AdminDto>(allCount, 1);
		}
		page.setT(adminDto);

		List<Admin> adminList = adminService.query(page);
		map.put("adminDto", adminDto);
		map.put("admin_list", adminList);
		map.put("admin_page", page);
		return "admin_main";
	}
}
