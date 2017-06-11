package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Kind;
import com.hxzy.order.page.Page;

public interface KindService {
	void delete(String ids);

	void update(Kind kind);

	List<Kind> query(Page page);

	Kind queryById(String id);
}
