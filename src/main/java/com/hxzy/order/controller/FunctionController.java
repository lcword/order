package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.order.model.Function;
import com.hxzy.order.model.Module;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.FunctionService;
import com.hxzy.order.service.intf.ModuleService;

@Controller
public class FunctionController {
	@Autowired
	private FunctionService functionService;
	@Autowired
	private ModuleService moduleService;

	@RequestMapping("pre_add_function")
	public String pre_add(Map<String, List<Module>> map) {
		map.put("module_list", moduleService.query(new Page(1, 1)));
		return "update_function";
	}

	@RequestMapping("pre_update_function")
	public String pre_update(Function function, Map<String, Object> map) {
		map.put("function", functionService.queryById(function.getId()));
		map.put("module_list", moduleService.query(new Page(1, 1)));
		return "update_function";
	}

	@RequestMapping("update_function")
	public String update(Function function, @RequestParam("module_id") String moduleId) {
		functionService.update(function, moduleId);
		return "redirect:query_function";
	}

	@RequestMapping("delete_function")
	public String delete(String id) {
		functionService.delete(id);
		return "redirect:query_function";
	}

}
