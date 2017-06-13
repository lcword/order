package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Card;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.CardService;

@Controller
public class QueryCardController {
	@Autowired
	private CardService cardService;

	@RequestMapping("query_card")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Card> cardList = cardService.query(page);
		map.put("card_list", cardList);
		map.put("card_page", page);
		return "card_main";
	}
}
