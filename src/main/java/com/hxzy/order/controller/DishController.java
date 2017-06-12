package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.DishService;
import com.hxzy.order.service.intf.KindService;

@Controller
public class DishController {
	@Autowired
	private DishService dishService;
	@Autowired
	private KindService kindService;
	
	@RequestMapping("pre_add_dish")
	public String pre_add(Map<String,Object> map) {
		map.put("kind_list",kindService.query(new Page(1,1)));
		return "update_dish";
	}

	@RequestMapping("pre_update_dish")
	public String pre_update(Dish dish,Map<String,Object> map) {
		map.put("kind_list",kindService.query(new Page(1,1)));
		map.put("dish", dishService.queryById(dish.getId()));
		return "update_dish";
	}

	@RequestMapping("update_dish")
	public String update(Dish dish,String kindId) {
		dishService.update(dish,kindId);
		return "redirect:query_dish";
	}

	@RequestMapping("delete_dish")
	public String delete(String id) {
		dishService.delete(id);
		return "redirect:query_dish";
	}

}
