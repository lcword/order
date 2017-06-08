package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Module;
import com.hxzy.order.service.intf.ModuleService;

@Controller
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("pre_add_module")
	public String pre_add() {
		return "update_module";
	}

	@RequestMapping("pre_update_module")
	public String pre_update(Module module,Map<String,Module> map) {
		map.put("module", moduleService.queryById(module.getId()));
		return "update_module";
	}

	@RequestMapping("update_module")
	public String update(Module module) {
		moduleService.update(module);
		return "redirect:query_module";
	}

	@RequestMapping("delete_module")
	public String delete(String id) {
		moduleService.delete(id);
		return "redirect:query_module";
	}

}
