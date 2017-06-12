package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.CardDao;
import com.hxzy.order.dao.intf.MemberDao;
import com.hxzy.order.model.Member;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.MemberService;

@Service("memberServcie")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private CardDao cardDao;
	
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		memberDao.delete(ids);
	}

	@Override
	public void update(Member member,String cardId) {
		member.setCard(cardDao.queryById(cardId));
		
		if(member.getId() == null || member.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = memberDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			member.setId("M" + date + String.valueOf(count));
			memberDao.add(member);
		}else{
			/*修改*/
			Member oldMember = memberDao.queryById(member.getId());
			
			oldMember.setName(member.getName());
			oldMember.setExpenditure(member.getExpenditure());
			oldMember.setBalance(member.getBalance());
			oldMember.setIntegral(member.getIntegral());
			oldMember.setPhone(member.getPhone());
			
			memberDao.update(oldMember);
		}
	}

	@Override
	public List<Member> query(Page page) {
		return memberDao.query(page);
	}

	@Override
	public Member queryById(String id) {
		return memberDao.queryById(id);
	}

}
