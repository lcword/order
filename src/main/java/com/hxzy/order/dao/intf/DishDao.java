package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;

public interface DishDao {
	void add(Dish dish);

	void delete(String ids);

	void update(Dish dish);

	List<Dish> query(Page page);
	
	Dish queryById(String id);
	
	int dayCount(String date);
}
