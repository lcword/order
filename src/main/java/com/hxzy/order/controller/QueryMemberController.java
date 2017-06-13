package com.hxzy.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.MemberService;

@Controller
public class QueryMemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("query_member")
	public String query(Map<String,Object> map,String type,String curPageStr) {

		Page page = new Page(1, 1);

		List<Member> memberList = memberService.query(page);
		map.put("member_list", memberList);
		map.put("member_page", page);
		return "member_main";
	}
}
