package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;

public interface DishService {
	void delete(String ids);

	void update(Dish dish);

	List<Dish> query(Page page);

	Dish queryById(String id);
}
