package com.hxzy.order.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.AdminService;
import com.hxzy.order.service.intf.CardService;
import com.hxzy.order.service.intf.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private CardService cardService;
	@Autowired
	private AdminService adminService;
	
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

	@RequestMapping("update_member")
	public String update(Member member,String cardId) {
		memberService.update(member,cardId);
		return "redirect:query_member";
	}

	@RequestMapping("delete_member")
	public String delete(String id) {
		memberService.delete(id);
		return "redirect:query_member";
	}
	
	@RequestMapping("pre_charge")
	public String preCharge(String id,Map<String,String> map) {
		map.put("id", id);
		return "charge";
	}

	@RequestMapping("charge")
	public String charge(String id,String money,Map<String,Object> map,HttpServletRequest request) {
		Member member = memberService.queryById(id);
		double balance = Double.valueOf(money);
		int integral = (int)(balance / 100);
		memberService.charge(id,balance,integral);
		member = memberService.queryById(id);
		
		map.put("member", member);
		map.put("money", money);
		map.put("integral", integral);
		map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		String adminId = request.getSession().getAttribute("login_user").toString();
		map.put("admin", adminService.queryById(adminId).getName());
		
		return "charge_success";
	}
}
