package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Card;
import com.hxzy.order.service.intf.CardService;

@Controller
public class CardController {
	@Autowired
	private CardService cardService;
	
	@RequestMapping("pre_add_card")
	public String pre_add() {
		return "update_card";
	}

	@RequestMapping("pre_update_card")
	public String pre_update(Card card,Map<String,Object> map) {
		map.put("card", cardService.queryById(card.getId()));
		return "update_card";
	}

	@RequestMapping("update_card")
	public String update(Card card,String functionId) {
		cardService.update(card);
		return "redirect:query_card";
	}

	@RequestMapping("delete_card")
	public String delete(String id) {
		cardService.delete(id);
		return "redirect:query_card";
	}

}
