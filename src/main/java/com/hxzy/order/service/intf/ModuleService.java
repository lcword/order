package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Module;
import com.hxzy.order.page.Page;

public interface ModuleService {
	void delete(String ids);

	void update(Module module);

	List<Module> query(Page page);
	
	Module queryById(String id);
}
