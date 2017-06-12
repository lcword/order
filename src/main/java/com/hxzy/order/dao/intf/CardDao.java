package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Card;
import com.hxzy.order.page.Page;

public interface CardDao {
	void add(Card card);

	void delete(String ids);

	void update(Card card);

	List<Card> query(Page page);
	
	Card queryById(String id);
	
	int dayCount(String date);
}
