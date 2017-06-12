package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Kind;
import com.hxzy.order.service.intf.KindService;

@Controller
public class KindController {
	@Autowired
	private KindService kindService;
	
	@RequestMapping("pre_add_kind")
	public String pre_add() {
		return "update_kind";
	}

	@RequestMapping("pre_update_kind")
	public String pre_update(Kind kind,Map<String,Object> map) {
		map.put("kind", kindService.queryById(kind.getId()));
		return "update_kind";
	}

	@RequestMapping("update_kind")
	public String update(Kind kind,String functionId) {
		kindService.update(kind);
		return "redirect:query_kind";
	}

	@RequestMapping("delete_kind")
	public String delete(String id) {
		kindService.delete(id);
		return "redirect:query_kind";
	}

}
