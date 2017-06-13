package com.hxzy.order.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.CardService;
import com.hxzy.order.service.intf.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private CardService cardService;
	
	@RequestMapping("pre_add_member")
	public String pre_add(Map<String,Object> map) {
		map.put("card_list",cardService.query(new Page(1,1)));
		return "update_member";
	}

	@RequestMapping("pre_update_member")
	public String pre_update(Member member,Map<String,Object> map) {
		map.put("card_list",cardService.query(new Page(1,1)));
		map.put("member", memberService.queryById(member.getId()));
		return "update_member";
	}

	@PostMapping("update_member")
	public String update(Member member,String cardId) {
		memberService.update(member,cardId);
		return "redirect:query_member";
	}

	@RequestMapping("delete_member")
	public String delete(String id) {
		memberService.delete(id);
		return "redirect:query_member";
	}

}
