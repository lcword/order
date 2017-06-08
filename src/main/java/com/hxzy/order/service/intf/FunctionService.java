package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Function;
import com.hxzy.order.model.Role;
import com.hxzy.order.page.Page;

public interface FunctionService {
	void delete(String ids);

	void update(Function function,String ModuleId);

	List<Function> query(Page page);
	
	Function queryById(String id);
}
