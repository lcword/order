package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.DishService;

@Controller
public class QueryDishController {
	@Autowired
	private DishService dishService;

	@RequestMapping("query_dish")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Dish> dishList = dishService.query(page);
		map.put("dish_list", dishList);
		map.put("dish_page", page);
		return "dish_main";
	}
}
