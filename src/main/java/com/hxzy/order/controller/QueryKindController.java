package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Kind;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.KindService;

@Controller
public class QueryKindController {
	@Autowired
	private KindService kindService;

	@RequestMapping("query_kind")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Kind> kindList = kindService.query(page);
		map.put("kind_list", kindList);
		map.put("kind_page", page);
		return "kind_main";
	}
}
