package com.hxzy.order.dao.intf;

import java.util.List;

import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;

public interface MemberDao {
	void add(Member member);

	void delete(String ids);

	void update(Member member);

	List<Member> query(Page page);
	
	Member queryById(String id);
	
	int dayCount(String date);
}
