package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Kind;
import com.hxzy.order.page.Page;

public interface KindDao {
	void add(Kind kind);

	void delete(String ids);

	void update(Kind kind);

	List<Kind> query(Page page);
	
	Kind queryById(String id);
	
	int dayCount(String date);
}
