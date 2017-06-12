package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.DishDao;
import com.hxzy.order.dao.intf.KindDao;
import com.hxzy.order.model.Dish;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.DishService;

@Service("dishServcie")
public class DishServiceImpl implements DishService{
	@Autowired
	private DishDao dishDao;
	@Autowired
	private KindDao kindDao;
	
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		dishDao.delete(ids);
	}

	@Override
	public void update(Dish dish,String kindId) {
		dish.setKind(kindDao.queryById(kindId));
		
		if(dish.getId() == null || dish.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = dishDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			dish.setId("D" + date + String.valueOf(count));
			dishDao.add(dish);
		}else{
			/*修改*/
			Dish oldDish = dishDao.queryById(dish.getId());
			
			oldDish.setName(dish.getName());
			oldDish.setPrice(dish.getPrice());
			oldDish.setStatus(dish.getStatus());
			oldDish.setPicture(dish.getPicture());
			oldDish.setRemark(dish.getRemark());
			
			dishDao.update(oldDish);
		}
	}

	@Override
	public List<Dish> query(Page page) {
		return dishDao.query(page);
	}

	@Override
	public Dish queryById(String id) {
		return dishDao.queryById(id);
	}

}
