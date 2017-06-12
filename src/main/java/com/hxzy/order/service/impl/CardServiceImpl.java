package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.CardDao;
import com.hxzy.order.model.Card;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.CardService;

@Service("cardServcie")
public class CardServiceImpl implements CardService{
	@Autowired
	private CardDao cardDao;
	
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		cardDao.delete(ids);
	}

	@Override
	public void update(Card card) {
		if(card.getId() == null || card.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = cardDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			card.setId("C" + date + String.valueOf(count));
			cardDao.add(card);
		}else{
			/*修改*/
			cardDao.update(card);
		}
	}

	@Override
	public List<Card> query(Page page) {
		return cardDao.query(page);
	}

	@Override
	public Card queryById(String id) {
		return cardDao.queryById(id);
	}

}
