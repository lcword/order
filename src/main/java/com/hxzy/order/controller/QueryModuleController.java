package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Module;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.ModuleService;

@Controller
public class QueryModuleController {
	@Autowired
	private ModuleService moduleService;

	@RequestMapping("query_module")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Module> moduleList = moduleService.query(page);
		map.put("module_list", moduleList);
		map.put("module_page", page);
		return "module_main";
	}
}
