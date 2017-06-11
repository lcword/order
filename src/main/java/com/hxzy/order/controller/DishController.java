package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Dish;
import com.hxzy.order.model.Function;
import com.hxzy.order.service.intf.DishService;

@Controller
public class DishController {
	@Autowired
	private DishService dishService;
	
	@RequestMapping("pre_add_dish")
	public String pre_add() {
		return "update_dish";
	}

	@RequestMapping("pre_update_dish")
	public String pre_update(Dish dish,Map<String,Object> map) {
		map.put("dish", dishService.queryById(dish.getId()));
		return "update_dish";
	}

	@RequestMapping("update_dish")
	public String update(Dish dish,String functionId) {
		dishService.update(dish);
		return "redirect:query_dish";
	}

	@RequestMapping("delete_dish")
	public String delete(String id) {
		dishService.delete(id);
		return "redirect:query_dish";
	}

}
