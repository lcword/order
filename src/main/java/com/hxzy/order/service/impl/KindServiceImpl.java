package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.KindDao;
import com.hxzy.order.model.Kind;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.KindService;

@Service("kindServcie")
public class KindServiceImpl implements KindService{
	@Autowired
	private KindDao kindDao;
	
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		kindDao.delete(ids);
	}

	@Override
	public void update(Kind kind) {
		if(kind.getId() == null || kind.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = kindDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			kind.setId("K" + date + String.valueOf(count));
			kindDao.add(kind);
		}else{
			/*修改*/
			kindDao.update(kind);
		}
	}

	@Override
	public List<Kind> query(Page page) {
		return kindDao.query(page);
	}

	@Override
	public Kind queryById(String id) {
		return kindDao.queryById(id);
	}

}
