package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Function;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.FunctionService;

@Controller
public class QueryFunctionController {
	@Autowired
	private FunctionService functionService;

	@RequestMapping("query_function")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Function> functionList = functionService.query(page);
		map.put("function_list", functionList);
		map.put("function_page", page);
		return "function_main";
	}
}
