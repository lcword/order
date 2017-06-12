package com.hxzy.order.service.intf;

import java.util.List;

import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;

public interface MemberService {
	void delete(String ids);

	void update(Member member,String cardId);

	List<Member> query(Page page);

	Member queryById(String id);
}
