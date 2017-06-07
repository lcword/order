package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Module;
import com.hxzy.order.page.Page;

public interface ModuleDao {
	void add(Module module);

	void delete(String ids);

	void update(Module module);

	List<Module> query(Page page);

	Module queryById(String id);

	int dayCount(String date);
}
