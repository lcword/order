package com.hxzy.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxzy.order.dao.intf.FunctionDao;
import com.hxzy.order.dao.intf.ModuleDao;
import com.hxzy.order.model.Function;
import com.hxzy.order.page.Page;
import com.hxzy.order.service.intf.FunctionService;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService{
	@Autowired
	private FunctionDao functionDao;
	@Autowired
	private ModuleDao moduleDao;
	private SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public void delete(String ids) {
		functionDao.delete(ids);
	}

	@Override
	public void update(Function function,String moduleId) {
		function.setModule(moduleDao.queryById(moduleId));
		if(function.getId() == null || function.getId().isEmpty()){
			/*增加*/
			String date = dateFormate.format(new Date());
			int count = functionDao.dayCount(date);
			if(++count < 100){
				date += "0";
			}
			if(count < 10){
				date += "0";
			}
			function.setId("F" + date + String.valueOf(count));
			functionDao.add(function);
		}else{
			/*修改*/
			functionDao.update(function);
		}
	}

	@Override
	public List<Function> query(Page page) {
		return functionDao.query(page);
	}

	@Override
	public Function queryById(String id) {
		return functionDao.queryById(id);
	}

}
