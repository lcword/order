package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Function;
import com.hxzy.order.service.intf.FunctionService;

@Controller
public class FunctionController {
	@Autowired
	private FunctionService functionService;
	
	@RequestMapping("pre_add_function")
	public String pre_add() {
		return "update_function";
	}

	@RequestMapping("pre_update_function")
	public String pre_update(Function function,Map<String,Function> map) {
		map.put("function", functionService.queryById(function.getId()));
		return "update_function";
	}

	@RequestMapping("update_function")
	public String update(Function function) {
		functionService.update(function);
		return "redirect:query_function";
	}

	@RequestMapping("delete_function")
	public String delete(String id) {
		functionService.delete(id);
		return "redirect:query_function";
	}

}
