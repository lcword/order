package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Function;
import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;

public interface FunctionDao {
	void add(Function function);

	void delete(String ids);

	void update(Function function);

	List<Function> query(Page page);

	Function queryById(String id);

	int dayCount(String date);
}
