package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Card;
import com.hxzy.order.page.Page;

public interface CardService {
	void delete(String ids);

	void update(Card card);

	List<Card> query(Page page);

	Card queryById(String id);
}
